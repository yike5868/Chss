package net.greatsoft.main.uiframe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.po.districts.Districts;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.fragment.FuListFragment;
import net.greatsoft.main.net.TaskManager;
import net.greatsoft.main.tool.IdCardValidator;
import net.greatsoft.main.tool.StringUtils;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.CircleButton;
import net.greatsoft.main.view.FuButton;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuImageView;
import net.greatsoft.main.view.FuTextView;
import net.greatsoft.main.view.ImageTextButton;
import net.greatsoft.main.view.pullToRefresh.PullToRefreshLayout;
import net.greatsoft.main.view.tree.Node;
import net.greatsoft.main.view.tree.SimpleTreeAdapter;
import net.greatsoft.main.view.tree.TreeListViewAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static net.greatsoft.main.fragment.FuListFragment.EVENT_CEREBRAL_INFO;
import static net.greatsoft.main.fragment.FuListFragment.EVENT_CHILD_INFO;
import static net.greatsoft.main.fragment.FuListFragment.EVENT_TUBERCULOSIS_INFO;

/**
 * Created by zhanglin on 2016/11/25.
 */

public class FuListView extends FuUiFrameModel implements View.OnClickListener, AdapterView.OnItemClickListener {

    MyAdapter myAdapter;

    LinearLayout ll_main;
    LinearLayout ll_search;

    List<PersonInfo> personInfoList;
    List<FamilyInfo> familyInfoList;
    ListView listView;

    ListView lv_search;


    List<PersonInfo> personInfoListTemp;
    List<FamilyInfo> familyInfoListTemp;

    /**
     * 搜索相关
     */
    ImageView iv_back;
    FuEditText et_search;
    ImageView iv_delete;
    FuButton btn_search;

    //    private String personInfoName;
    private int pageNo = 1;
    private int pageSize = 10;
    private String districtId;
    private Integer districtLevel;
    PullToRefreshLayout pullToRefreshLayout;

    private int listType;

    FuTextView jkx_title_center;//标题

    private Dialog bottomDialog; //底层弹出框
    private Dialog rightDialog; //底层弹出框
    private View inflate;
    private View rinflate;

    ImageTextButton itb_hyper; //高血压
    ImageTextButton itb_diabetes;//糖尿病
    ImageTextButton itb_exam;//体检
    ImageTextButton itb_hyper_info;//高血压专档
    ImageTextButton itb_coronaryHeart_info;//冠心病专档
    ImageTextButton itb_maternal_register;//孕产登记
    ImageTextButton itb_cerebral_info;//脑卒中专档
    ImageTextButton itb_child_info;//儿童专档
    ImageTextButton itb_tuberculosis_info;//肺结核专档
    ImageTextButton itb_diabetes_info;//糖尿病专档
    ImageTextButton itb_elder_info;//老年人花名册
    ImageTextButton itb_smi;//精神病
    ImageTextButton itb_smi_info;//精神病补充信息
    ImageTextButton itb_selfcare;//老年人自理能力
    ImageTextButton itb_cognition;//老年人认知功能
    ImageTextButton itb_depressed;//老年人抑郁
    ImageTextButton itb_elder_tcm;//老年人中医药

    ImageTextButton itb_child_health_1;//新生儿
    ImageTextButton itb_child_health_2;//1-8月
    ImageTextButton itb_child_health_3;//12-30个月
    ImageTextButton itb_child_health_4;//3-6岁


    ImageTextButton itb_maternal_1;//第一次产前随访
    ImageTextButton itb_maternal_2;//2-5次
    ImageTextButton itb_maternal_3;//产后访视
    ImageTextButton itb_maternal_4;//产后42天访视

    ImageTextButton itb_disability_hear;//听力言语残疾
    ImageTextButton itb_disability_intelligence;//智力残疾
    ImageTextButton itb_disability_limb;//肢体残疾
    ImageTextButton itb_disability_visul;//视力残疾

    ImageTextButton itb_tuberculosisFirstFollowUp;//肺结核患者第一次入户随访
    ImageTextButton itb_tuberculosisFollowUp;//肺结核患者随访

    ImageTextButton itb_chd;//冠心病
    ImageTextButton itb_ca;//脑卒中

    ImageTextButton itb_edit;//编辑
    ImageTextButton itb_delete;//删除


    ImageTextButton itb_cdcVaccreport;//预防接种卡
    ImageTextButton itb_cdcVaccreportVaccinate;//预防接种记录

    FuImageView fu_iv_title_right_btn;   //右
    FuImageView fu_iv_title_right_btn2; //中
    FuImageView fu_iv_title_right_btn3; //左


    List<Districts> districtsList;//村居委会  搜索使用

    public FuListView(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }


    @Override
    protected void createFuLayout() {

        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.fu_list_view, null);
    }

    @Override
    protected void initFuData() {
        familyInfoList = new ArrayList<>();
        personInfoList = new ArrayList<>();
        familyInfoListTemp = new ArrayList<>();
        personInfoListTemp = new ArrayList<>();
    }

    /**
     * 添加家庭
     *
     * @param familyInfoList
     */
    public void setFamilyInfoList(List<FamilyInfo> familyInfoList) {
        this.familyInfoList.addAll(familyInfoList);
        loadmoreFinish();
        refreshFinish();
        myAdapter.notifyDataSetChanged();
    }

    /**
     * 添加人员
     *
     * @param personInfoList
     */
    public void setPersonInfoList(List<PersonInfo> personInfoList) {
        this.personInfoList.addAll(personInfoList);
        loadmoreFinish();
        refreshFinish();
        myAdapter.notifyDataSetChanged();
    }

    public void setData(int _listType) {
        listType = _listType;
        switch (listType) {
            case FuListFragment.EVENT_FAMILY:
                jkx_title_center.setText("家庭");
                fu_iv_title_right_btn.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);

                break;
            case FuListFragment.EVENT_PERSON:
                jkx_title_center.setText("人员");
                fu_iv_title_right_btn.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_HYPER:
                jkx_title_center.setText("高血压");
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_DIABETES:
                jkx_title_center.setText("2型糖尿病");
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_COGNITION:
                jkx_title_center.setText("老年人");
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                break;

            case FuListFragment.EVENT_SMI:
                jkx_title_center.setText("严重精神病障碍");
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                break;

            case FuListFragment.EVENT_CHILD:
                jkx_title_center.setText("儿童");
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_MATERNAL:
                jkx_title_center.setText("孕产妇");
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_TUBERCULOSIS:
                jkx_title_center.setText("肺结核");
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_VACCINE:
                jkx_title_center.setText("儿童预防免疫");
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_CORONARYHEART:
                jkx_title_center.setText("冠心病");
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_CEREBRALAPOPLEXY:
                jkx_title_center.setText("脑卒中");
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_DISABILITY:
                jkx_title_center.setText("残疾人");
                fu_iv_title_right_btn3.setVisibility(View.VISIBLE);
                fu_iv_title_right_btn2.setVisibility(View.VISIBLE);
                break;

        }
//        makeBottomDialog();
        makeRightDialog();
    }


    @Override
    protected void initWidget() {

        jkx_title_center = (FuTextView) mFuView
                .findViewById(R.id.fu_title_center);

        ll_main = (LinearLayout) mFuView.findViewById(R.id.ll_main);
        ll_search = (LinearLayout) mFuView.findViewById(R.id.ll_search);


        fu_iv_title_right_btn = (FuImageView) mFuView.findViewById(R.id.fu_iv_title_right_btn);   //右
        fu_iv_title_right_btn2 = (FuImageView) mFuView.findViewById(R.id.fu_iv_title_right_btn2); //中
        fu_iv_title_right_btn3 = (FuImageView) mFuView.findViewById(R.id.fu_iv_title_right_btn3); //左

        fu_iv_title_right_btn.setOnClickListener(this);
        fu_iv_title_right_btn2.setOnClickListener(this);
        fu_iv_title_right_btn3.setOnClickListener(this);


        pullToRefreshLayout = ((PullToRefreshLayout) mFuView.findViewById(R.id.refresh_view));
        pullToRefreshLayout.setOnRefreshListener(new PullToRefreshListener());

        listView = (ListView) mFuView.findViewById(R.id.content_view);
        myAdapter = new MyAdapter(mContext);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);


        lv_search = (ListView) mFuView.findViewById(R.id.lv_search);
        lv_search.setAdapter(myAdapter);
        lv_search.setOnItemClickListener(this);


//        initExpandableListView();
        iv_back = (ImageView) mFuView.findViewById(R.id.iv_back);
        et_search = (FuEditText) mFuView.findViewById(R.id.et_search);
        iv_delete = (ImageView) mFuView.findViewById(R.id.iv_delete);
        btn_search = (FuButton) mFuView.findViewById(R.id.btn_search);

        iv_back.setOnClickListener(this);
        iv_delete.setOnClickListener(this);
        btn_search.setOnClickListener(this);

    }


    public void makeBottomDialog(int position) {
        bottomDialog = new Dialog(mContext, R.style.ActionSheetDialogStyle);

        inflate = LayoutInflater.from(mContext).inflate(R.layout.bottom_dialog_layout, null);

        itb_hyper = (ImageTextButton) inflate.findViewById(R.id.itb_hyper); //高血压
        itb_diabetes = (ImageTextButton) inflate.findViewById(R.id.itb_diabetes);//糖尿病
        itb_exam = (ImageTextButton) inflate.findViewById(R.id.itb_exam);//体检
        itb_hyper_info = (ImageTextButton) inflate.findViewById(R.id.itb_hyper_info);//高血压专档
        itb_coronaryHeart_info = (ImageTextButton) inflate.findViewById(R.id.itb_coronaryHeart_info);//冠心病专档
        itb_maternal_register = (ImageTextButton) inflate.findViewById(R.id.itb_maternal_register);//孕产登记
        itb_cerebral_info = (ImageTextButton) inflate.findViewById(R.id.itb_cerebral_info);//脑卒中专档
        itb_child_info = (ImageTextButton) inflate.findViewById(R.id.itb_child_info);//儿童专档
        itb_tuberculosis_info = (ImageTextButton) inflate.findViewById(R.id.itb_tuberculosis_info);//肺结核专档
        itb_diabetes_info = (ImageTextButton) inflate.findViewById(R.id.itb_diabetes_info);//高血压专档
        itb_elder_info = (ImageTextButton) inflate.findViewById(R.id.itb_elder_info);//老年人花名册
        itb_smi = (ImageTextButton) inflate.findViewById(R.id.itb_smi);//精神病
        itb_smi_info = (ImageTextButton) inflate.findViewById(R.id.itb_smi_info);//精神病补充信息
        itb_selfcare = (ImageTextButton) inflate.findViewById(R.id.itb_selfcare);//老年人自理能力
        itb_cognition = (ImageTextButton) inflate.findViewById(R.id.itb_cognition);//老年人认知功能
        itb_depressed = (ImageTextButton) inflate.findViewById(R.id.itb_depressed);//老年人抑郁
        itb_elder_tcm = (ImageTextButton) inflate.findViewById(R.id.itb_elder_tcm);//老年人中医药
        itb_edit = (ImageTextButton) inflate.findViewById(R.id.itb_edit);//编辑
        itb_delete = (ImageTextButton) inflate.findViewById(R.id.itb_delete);//删除

        itb_child_health_1 = (ImageTextButton) inflate.findViewById(R.id.itb_child_health_1);//新生儿
        itb_child_health_2 = (ImageTextButton) inflate.findViewById(R.id.itb_child_health_2);//1-8月
        itb_child_health_3 = (ImageTextButton) inflate.findViewById(R.id.itb_child_health_3);//12-30个月
        itb_child_health_4 = (ImageTextButton) inflate.findViewById(R.id.itb_child_health_4);//3-6岁


        itb_maternal_1 = (ImageTextButton) inflate.findViewById(R.id.itb_maternal_1);//第一次产前随访
        itb_maternal_2 = (ImageTextButton) inflate.findViewById(R.id.itb_maternal_2);//2-5次
        itb_maternal_3 = (ImageTextButton) inflate.findViewById(R.id.itb_maternal_3);//产后访视
        itb_maternal_4 = (ImageTextButton) inflate.findViewById(R.id.itb_maternal_4);//产后42天访视

        itb_disability_hear = (ImageTextButton) inflate.findViewById(R.id.itb_disability_hear);//听力言语残疾
        itb_disability_intelligence = (ImageTextButton) inflate.findViewById(R.id.itb_disability_intelligence);//智力残疾
        itb_disability_limb = (ImageTextButton) inflate.findViewById(R.id.itb_disability_limb);//肢体残疾
        itb_disability_visul = (ImageTextButton) inflate.findViewById(R.id.itb_disability_visul);//视力残疾

        itb_tuberculosisFirstFollowUp = (ImageTextButton) inflate.findViewById(R.id.itb_tuberculosisFirstFollowUp);//肺结核患者第一次入户随访
        itb_tuberculosisFollowUp = (ImageTextButton) inflate.findViewById(R.id.itb_tuberculosisFollowUp);//肺结核患者随访
        itb_chd = (ImageTextButton) inflate.findViewById(R.id.itb_chd);//冠心病患者随访
        itb_ca = (ImageTextButton) inflate.findViewById(R.id.itb_ca);//脑卒中患者随访
        itb_cdcVaccreport = (ImageTextButton) inflate.findViewById(R.id.itb_cdcVaccreport);//预防接种卡
        itb_cdcVaccreportVaccinate = (ImageTextButton) inflate.findViewById(R.id.itb_cdcVaccreportVaccinate);//预防接种记录
        itb_hyper.setOnClickListener(this); //高血压
        itb_hyper_info.setOnClickListener(this);//高血压专档
        itb_coronaryHeart_info.setOnClickListener(this);//冠心病专档
        itb_maternal_register.setOnClickListener(this);//孕产登记
        itb_cerebral_info.setOnClickListener(this);//脑卒中专档
        itb_child_info.setOnClickListener(this);//儿童中专档
        itb_tuberculosis_info.setOnClickListener(this);//肺结核专档
        itb_diabetes_info.setOnClickListener(this);//糖尿病专档
        itb_elder_info.setOnClickListener(this);//老年人花名册
        itb_diabetes.setOnClickListener(this);//糖尿病
        itb_exam.setOnClickListener(this);//体检
        itb_smi.setOnClickListener(this);//精神病
        itb_smi_info.setOnClickListener(this);//精神补充信息
        itb_selfcare.setOnClickListener(this);//老年人自理能力
        itb_cognition.setOnClickListener(this);//老年人认知功能
        itb_depressed.setOnClickListener(this);//老年人抑郁
        itb_elder_tcm.setOnClickListener(this);//老年人中医药

        itb_child_health_1.setOnClickListener(this);//新生儿
        itb_child_health_2.setOnClickListener(this);//1-8月
        itb_child_health_3.setOnClickListener(this);//12-30个月
        itb_child_health_4.setOnClickListener(this);//3-6岁

        itb_maternal_1.setOnClickListener(this);//第一次产前随访
        itb_maternal_2.setOnClickListener(this);//2-5次
        itb_maternal_3.setOnClickListener(this);//产后访视
        itb_maternal_4.setOnClickListener(this);//产后42天访视
        itb_disability_hear.setOnClickListener(this);//听力言语残疾
        itb_disability_intelligence.setOnClickListener(this);//智力残疾
        itb_disability_limb.setOnClickListener(this);//肢体残疾
        itb_disability_visul.setOnClickListener(this);//视力残疾

        itb_tuberculosisFirstFollowUp.setOnClickListener(this);//肺结核患者第一次入户随访
        itb_tuberculosisFollowUp.setOnClickListener(this);//肺结核患者随访

        itb_chd.setOnClickListener(this);//冠心病患者随访
        itb_ca.setOnClickListener(this);//脑卒中患者随访

        itb_cdcVaccreport.setOnClickListener(this);//预防接种卡
        itb_cdcVaccreportVaccinate.setOnClickListener(this);//预防接种记录

        itb_edit.setOnClickListener(this);//编辑
        itb_delete.setOnClickListener(this);//删除

        switch (listType) {
            case FuListFragment.EVENT_FAMILY:
                //家庭没有弹出框
                break;
            //人员
            case FuListFragment.EVENT_PERSON:

                Integer age = getAge(personInfoList.get(position).getBirthday());
                itb_edit.setVisibility(View.VISIBLE);
                //精神病
                if (personInfoList.get(position).getIsSmi() == null || 0 == personInfoList.get(position).getIsSmi() || "".equals(personInfoList.get(position).getIsSmi()))
                    itb_smi_info.setVisibility(View.VISIBLE);
                //高血压
                if (personInfoList.get(position).getIsHypertension() == null || 0 == personInfoList.get(position).getIsHypertension() || "".equals(personInfoList.get(position).getIsHypertension()))
                    itb_hyper_info.setVisibility(View.VISIBLE);
                //冠心病
                if (personInfoList.get(position).getIsChd() == null || 0 == personInfoList.get(position).getIsChd() || "".equals(personInfoList.get(position).getIsChd()))
                    itb_coronaryHeart_info.setVisibility(View.VISIBLE);
                //脑卒中
                if (personInfoList.get(position).getIsCa() == null || 0 == personInfoList.get(position).getIsCa() || "".equals(personInfoList.get(position).getIsCa()))
                    itb_cerebral_info.setVisibility(View.VISIBLE);
                //儿童
                if (age >= 0 && age <= 14 && (personInfoList.get(position).getIsChild() == null || 0 == personInfoList.get(position).getIsChild() || "".equals(personInfoList.get(position).getIsChild())))
                    itb_child_info.setVisibility(View.VISIBLE);
                //肺结核
                if (personInfoList.get(position).getIsTuberculosis() == null || 0 == personInfoList.get(position).getIsTuberculosis() || "".equals(personInfoList.get(position).getIsTuberculosis()))
                    itb_tuberculosis_info.setVisibility(View.VISIBLE);
                //糖尿病
                if (personInfoList.get(position).getIsDiabetes() == null || 0 == personInfoList.get(position).getIsDiabetes() || "".equals(personInfoList.get(position).getIsDiabetes()))
                    itb_diabetes_info.setVisibility(View.VISIBLE);
                //老年人
                if (age >= 65 && (personInfoList.get(position).getIsElder() == null || 0 == personInfoList.get(position).getIsElder() || "".equals(personInfoList.get(position).getIsElder())))
                    itb_elder_info.setVisibility(View.VISIBLE);
                //孕产登记
                if (age >= 15 && age <= 64 && personInfoList.get(position).getSexCode().equals("2") && (personInfoList.get(position).getIsMaternal() == null || 0 == personInfoList.get(position).getIsMaternal() || "".equals(personInfoList.get(position).getIsMaternal())))
                    itb_maternal_register.setVisibility(View.VISIBLE);

                itb_exam.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_HYPER:
                itb_hyper.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_DIABETES:
                itb_diabetes.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_COGNITION:
                itb_selfcare.setVisibility(View.VISIBLE);
                itb_cognition.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                itb_elder_tcm.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_SMI:

                itb_smi.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_CHILD:
                itb_child_health_1.setVisibility(View.VISIBLE);
                itb_child_health_2.setVisibility(View.VISIBLE);
                itb_child_health_3.setVisibility(View.VISIBLE);
                itb_child_health_4.setVisibility(View.VISIBLE);
                break;

            case FuListFragment.EVENT_VACCINE:
                itb_cdcVaccreport.setVisibility(View.VISIBLE);//预防接种卡
                itb_cdcVaccreportVaccinate.setVisibility(View.VISIBLE);//预防接种记录
                break;

            case FuListFragment.EVENT_MATERNAL:
                itb_maternal_1.setVisibility(View.VISIBLE);
                itb_maternal_2.setVisibility(View.VISIBLE);
                itb_maternal_3.setVisibility(View.VISIBLE);
                itb_maternal_4.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_TUBERCULOSIS:
                itb_tuberculosisFirstFollowUp.setVisibility(View.VISIBLE);
                itb_tuberculosisFollowUp.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_CORONARYHEART:
                itb_chd.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_CEREBRALAPOPLEXY:
                itb_ca.setVisibility(View.VISIBLE);
                itb_exam.setVisibility(View.VISIBLE);
                break;
            case FuListFragment.EVENT_DISABILITY:
                if (personInfoList.get(position).getIsDisabilityHearing() != null && personInfoList.get(position).getIsDisabilityHearing() == 1)
                    itb_disability_hear.setVisibility(View.VISIBLE);//听力言语残疾
                if (personInfoList.get(position).getIsDisabilityLanguage() != null && personInfoList.get(position).getIsDisabilityLanguage() == 1)
                    itb_disability_hear.setVisibility(View.VISIBLE);//听力言语残疾
                if (personInfoList.get(position).getIsDisabilityBrain() != null && personInfoList.get(position).getIsDisabilityBrain() == 1)
                    itb_disability_intelligence.setVisibility(View.VISIBLE);//智力残疾
                if (personInfoList.get(position).getIsDisabilityLimbs() != null && personInfoList.get(position).getIsDisabilityLimbs() == 1)
                    itb_disability_limb.setVisibility(View.VISIBLE);//肢体残疾
                if (personInfoList.get(position).getIsDisabilityEyesight() != null && personInfoList.get(position).getIsDisabilityEyesight() == 1)
                    itb_disability_visul.setVisibility(View.VISIBLE);//视力残疾
                itb_exam.setVisibility(View.VISIBLE);
                break;
        }
        bottomDialog.setContentView(inflate);
        Window dialogWindow = bottomDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();

        lp.width = WindowManager.LayoutParams.MATCH_PARENT;

        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        int i = allayout_main.getLineNum();
//        lp.height = 700;
        dialogWindow.setAttributes(lp);

    }

    public Integer getAge(Date birthday) {
        if (birthday == null) {
            return 0;
        }
        Calendar now = Calendar.getInstance();
        Calendar birthCal = Calendar.getInstance();
        birthCal.setTime(birthday);
        int monthGap = now.get(Calendar.MONTH) - birthCal.get(Calendar.MONTH);
        int yearGap = (now.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR)) * 12;
        int gapMonth = monthGap + yearGap;
        return gapMonth / 12;
    }

    public void makeRightDialog() {
        districtsList = sqlHelper.getDistrictsAll();
        rightDialog = new Dialog(mContext, R.style.ActionSheetRightDialogStyle);
        rinflate = LayoutInflater.from(mContext).inflate(R.layout.right_dialog_layout, null);
        ListView lv_tree = (ListView) rinflate.findViewById(R.id.lv_tree);
        SimpleTreeAdapter simpleTreeAdapter = null;
        try {
            simpleTreeAdapter = new SimpleTreeAdapter<Districts>(lv_tree, mContext, districtsList, 10);
            simpleTreeAdapter.setOnTreeNodeClickListener(onTreeNodeClickListener);

        } catch (Exception e) {
            e.printStackTrace();
        }
        lv_tree.setAdapter(simpleTreeAdapter);
        rightDialog.setContentView(rinflate);
        Window rdialogWindow = rightDialog.getWindow();
        rdialogWindow.setGravity(Gravity.RIGHT);
        WindowManager.LayoutParams rlp = rdialogWindow.getAttributes();


        float wid = mContext.getResources().getDimension(R.dimen.right_wight);
        rlp.width = (int) wid;
        rlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        rlp.y = 20;
        rdialogWindow.setAttributes(rlp);

    }

    /**
     * 多级菜单的点击事件监听
     */
    TreeListViewAdapter.OnTreeNodeClickListener onTreeNodeClickListener = new TreeListViewAdapter.OnTreeNodeClickListener() {
        @Override
        public void onClick(Node node, int position) {
            if (node.isLeaf()) {

                familyInfoList.clear();
                personInfoList.clear();
                myAdapter.notifyDataSetChanged();

                rightDialog.dismiss();
                pageNo = 1;

                districtId = districtsList.get(position).getDistrictId();
                districtLevel = districtsList.get(position).getDistrictLevel();

                getData();
            }
        }
    };

    public void getData() {
        Bundle bundle = new Bundle();
        HashMap<String, Object> hashMap = new HashMap<>();

        boolean flag = false;
        if (ll_search.getVisibility() == View.VISIBLE) {
            flag = true;
            String body = et_search.getText().toString().trim();

            if (body == null || "".equals(body)) {
                ToastUtil.showToast(mContext, "请输入查询条件", Toast.LENGTH_SHORT);
                return;
            }

            if (IdCardValidator.isValidatedAllIdcard(body)) {
                hashMap.put("idNo", body);
            } else if (StringUtils.isNum(body) && body.length() == 17) {
                hashMap.put("personInfoNo", body);
            } else {
                if (listType == FuListFragment.EVENT_FAMILY) {
                    hashMap.put("householder", body);
                } else {
                    hashMap.put("name", body);
                }
            }
        }

        switch (listType) {

            case FuListFragment.EVENT_PERSON:
                break;
            case FuListFragment.EVENT_FAMILY:
                break;
            case FuListFragment.EVENT_SMI:
                hashMap.put("isPhychosis", 1);
                break;
            case FuListFragment.EVENT_COGNITION:
                hashMap.put("isOld", 1);
                break;
            case FuListFragment.EVENT_HYPER:
                hashMap.put("isHyper", 1);
                break;
            case FuListFragment.EVENT_DIABETES:
                hashMap.put("isDiabetes", 1);
                break;
            case FuListFragment.EVENT_VACCINE:
            case FuListFragment.EVENT_CHILD:
                hashMap.put("isChildren", 1);
                break;
            case FuListFragment.EVENT_MATERNAL:
                hashMap.put("isMaternal", 1);
                hashMap.put("isWomen", 1);
                break;
            case FuListFragment.EVENT_TUBERCULOSIS:
                hashMap.put("isTuberculosis", 1);
                break;
            case FuListFragment.EVENT_CORONARYHEART:
                hashMap.put("isChd", 1);
                break;
            case FuListFragment.EVENT_CEREBRALAPOPLEXY:
                hashMap.put("isCa", 1);
                break;
            case FuListFragment.EVENT_DISABILITY:
                hashMap.put("disability1", 1);
                break;
        }

        if (districtId == null || districtLevel == null) {
            districtId = TaskManager.getInstace().getDistrictId(mContext);
            districtLevel = Integer.parseInt(TaskManager.getInstace().getDistrictLev(mContext));
        }
        bundle.putInt("pageNo", pageNo);
        if (flag) {
            bundle.putInt("pageSize", 100);
        } else
            bundle.putInt("pageSize", pageSize);
        hashMap.put("districtId", districtId);
        hashMap.put("districtLevel", districtLevel);
        bundle.putSerializable("param", hashMap);
        mEventCallBack.EventClick(FuListFragment.EVENT_GET_DATA, bundle);

    }

    public void showBottomDialog(int position) {

        int tag = position;
//        personInfoName = personInfoList.get(position).getName();


        itb_hyper.setTag(tag); //高血压
        itb_hyper_info.setTag(tag);//高血压专档
        itb_coronaryHeart_info.setTag(tag);//冠心病专档
        itb_maternal_register.setTag(tag);//孕产登记
        itb_cerebral_info.setTag(tag);//脑卒中专档
        itb_child_info.setTag(tag);//儿童专档
        itb_tuberculosis_info.setTag(tag);//肺结核专档
        itb_diabetes_info.setTag(tag);//糖尿病专档
        itb_elder_info.setTag(tag);//老年人花名册
        itb_diabetes.setTag(tag);//糖尿病
        itb_exam.setTag(tag);//体检
        itb_smi.setTag(tag);//精神病
        itb_smi_info.setTag(tag);//精神病补充信息
        itb_selfcare.setTag(tag);//老年人自理能力
        itb_cognition.setTag(tag);//老年人认知功能
        itb_depressed.setTag(tag);//老年人抑郁
        itb_elder_tcm.setTag(tag);//老年人中医药
        itb_edit.setTag(tag);

        itb_cdcVaccreport.setTag(tag);//预防接种卡
        itb_cdcVaccreportVaccinate.setTag(tag);//预防接种记录

        itb_tuberculosisFirstFollowUp.setTag(tag);
        itb_tuberculosisFollowUp.setTag(tag);
        itb_child_health_1.setTag(tag);//新生儿
        itb_child_health_2.setTag(tag);//1-8月
        itb_child_health_3.setTag(tag);//12-30个月
        itb_child_health_4.setTag(tag);//3-6岁
        itb_maternal_1.setTag(tag);//第一次产前随访
        itb_maternal_2.setTag(tag);//2-5次
        itb_maternal_3.setTag(tag);//产后访视
        itb_maternal_4.setTag(tag);//产后42天访视
        itb_chd.setTag(tag);//冠心病
        itb_ca.setTag(tag);//脑卒中
        itb_disability_hear.setTag(tag);//听力言语残疾
        itb_disability_intelligence.setTag(tag);//智力残疾
        itb_disability_limb.setTag(tag);//肢体残疾
        itb_disability_visul.setTag(tag);//视力残疾

        bottomDialog.show();


    }

    public void showRightDialog() {
        rightDialog.show();
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        if (v.getTag() == null) {

        } else {
            int pon = Integer.parseInt(v.getTag().toString());

            bundle.putString("personInfoId", personInfoList.get(pon).getPersonInfoId());
            bundle.putString("personInfoName", personInfoList.get(pon).getName());
            bundle.putString("personInfoNo", personInfoList.get(pon).getPersonInfoNo());
            bundle.putSerializable("personInfo", personInfoList.get(pon));
        }
        if (bottomDialog != null && bottomDialog.isShowing())
            bottomDialog.dismiss();
        switch (v.getId()) {
            case R.id.fu_iv_title_right_btn:
                if (listType == FuListFragment.EVENT_FAMILY) {
                    mEventCallBack.EventClick(FuListFragment.EVENT_FAMILY_ADD, bundle);
                } else if (listType == FuListFragment.EVENT_PERSON) {
                    mEventCallBack.EventClick(FuListFragment.EVENT_PERSON_ADD, bundle);
                }
                break;
            case R.id.fu_iv_title_right_btn2:
                ll_main.setVisibility(View.GONE);
                ll_search.setVisibility(View.VISIBLE);

                setSearch();


//                bundle.putInt("listType", listType);
//                mEventCallBack.EventClick(FuListFragment.EVENT_SEARCH, bundle);
                break;
            case R.id.fu_iv_title_right_btn3:
                showRightDialog();
                break;

            case R.id.itb_hyper:
                mEventCallBack.EventClick(FuListFragment.EVENT_HYPER, bundle);
                break;
            case R.id.itb_hyper_info:
                mEventCallBack.EventClick(FuListFragment.EVENT_HYPER_INFO, bundle);
                break;
            case R.id.itb_coronaryHeart_info:
                mEventCallBack.EventClick(FuListFragment.EVENT_CORONARYHEART_INFO, bundle);
                break;
            case R.id.itb_maternal_register:
                mEventCallBack.EventClick(FuListFragment.EVENT_MATERNAL_REGISTER, bundle);
                break;
            case R.id.itb_cerebral_info:
                mEventCallBack.EventClick(EVENT_CEREBRAL_INFO, bundle);
                break;

            case R.id.itb_child_info:
                mEventCallBack.EventClick(EVENT_CHILD_INFO, bundle);
                break;
            case R.id.itb_tuberculosis_info:
                mEventCallBack.EventClick(EVENT_TUBERCULOSIS_INFO, bundle);
                break;
            case R.id.itb_diabetes_info:
                mEventCallBack.EventClick(FuListFragment.EVENT_DIABETES_INFO, bundle);
                break;
            case R.id.itb_elder_info:
                mEventCallBack.EventClick(FuListFragment.EVENT_ELDER_INFO, bundle);
                break;
            case R.id.itb_diabetes:
                mEventCallBack.EventClick(FuListFragment.EVENT_DIABETES, bundle);
                break;
            case R.id.itb_exam:
                mEventCallBack.EventClick(FuListFragment.EVENT_EXAM, bundle);
                break;
            case R.id.itb_smi:
                mEventCallBack.EventClick(FuListFragment.EVENT_SMI, bundle);
                break;
            case R.id.itb_smi_info:
                mEventCallBack.EventClick(FuListFragment.EVENT_SMI_INFO, bundle);
                break;

            case R.id.itb_selfcare:
                mEventCallBack.EventClick(FuListFragment.EVENT_SELFCARE, bundle);
                break;
            case R.id.itb_elder_tcm:
                mEventCallBack.EventClick(FuListFragment.EVENT_ELDER_TCM, bundle);
                break;
            case R.id.itb_cognition:
                mEventCallBack.EventClick(FuListFragment.EVENT_COGNITION, bundle);
                break;
            case R.id.itb_depressed:
                mEventCallBack.EventClick(FuListFragment.EVENT_DEPRESSED, bundle);
                break;
            case R.id.itb_edit:
                mEventCallBack.EventClick(FuListFragment.EVENT_PERSON, bundle);
                break;

            case R.id.itb_child_health_1:
                mEventCallBack.EventClick(FuListFragment.EVNET_CHILD_HOME_VISIT, bundle);
                break;
            case R.id.itb_child_health_2:
                mEventCallBack.EventClick(FuListFragment.EVENT_CHILD_HEALTH_EXAM_02, bundle);
                break;
            case R.id.itb_child_health_3:
                mEventCallBack.EventClick(FuListFragment.EVENT_CHILD_HEALTH_EXAM_03, bundle);
                break;
            case R.id.itb_child_health_4:
                mEventCallBack.EventClick(FuListFragment.EVENT_CHILD_HEALTH_EXAM_04, bundle);
                break;

            case R.id.itb_maternal_1:
                mEventCallBack.EventClick(FuListFragment.EVENT_MATERNAL_FIRST_FOLLOW_UP, bundle);
                break;
            case R.id.itb_maternal_2:
                mEventCallBack.EventClick(FuListFragment.EVENT_MATERNAL_FOLLOW_UP, bundle);
                break;
            case R.id.itb_maternal_3:
                bundle.putInt("type", 0);//0  产后随访
                mEventCallBack.EventClick(FuListFragment.EVENT_MATERNAL_POSTPARTUM_FOLLOWUP, bundle);
                break;
            case R.id.itb_maternal_4:
                bundle.putInt("type", 1);//1  产后42天随访
                mEventCallBack.EventClick(FuListFragment.EVENT_MATERNAL_POSTPARTUM_FOLLOWUP, bundle);
                break;
            case R.id.iv_back:
                ll_search.setVisibility(View.GONE);
                ll_main.setVisibility(View.VISIBLE);
                setData();
                break;
            case R.id.iv_delete:
                et_search.setText("");
                break;
            case R.id.btn_search:
                setSearch();//每次搜索都清空一下数据
                getData();
                break;
            case R.id.itb_tuberculosisFirstFollowUp://肺结核患者第一次入户随访
                mEventCallBack.EventClick(FuListFragment.EVENT_TUBERCULOSIS_FIRST_FOLLOWUP, bundle);
                break;
            case R.id.itb_tuberculosisFollowUp://肺结核患者随访
                mEventCallBack.EventClick(FuListFragment.EVENT_TUBERCULOSIS_FOLLOWUP, bundle);
                break;

            case R.id.itb_cdcVaccreport://预防接种卡
                mEventCallBack.EventClick(FuListFragment.EVENT_CDCVACCREPORT, bundle);
                break;
            case R.id.itb_cdcVaccreportVaccinate://预防接种记录
                mEventCallBack.EventClick(FuListFragment.EVENT_CDCVACCREPORT_VACCINATE, bundle);
                break;
            case R.id.itb_chd://冠心病
                mEventCallBack.EventClick(FuListFragment.EVENT_CORONARYHEART, bundle);
                break;
            case R.id.itb_ca://脑卒中
                mEventCallBack.EventClick(FuListFragment.EVENT_CEREBRALAPOPLEXY, bundle);
                break;
            case R.id.itb_disability_hear://听力言语残疾
                mEventCallBack.EventClick(FuListFragment.EVENT_DISABILITY_HEAR, bundle);
                break;
            case R.id.itb_disability_intelligence://智力残疾
                mEventCallBack.EventClick(FuListFragment.EVENT_DISABILITY_INTELLIGENCE, bundle);
                break;
            case R.id.itb_disability_limb://肢体残疾
                mEventCallBack.EventClick(FuListFragment.EVENT_DISABILITY_LIMB, bundle);
                break;
            case R.id.itb_disability_visul://视力残疾
                mEventCallBack.EventClick(FuListFragment.EVENT_DISABILITY_VISUAL, bundle);
                break;


        }
    }


    private void setSearch() {
        personInfoListTemp.clear();
        personInfoListTemp.addAll(personInfoList);

        familyInfoListTemp.clear();
        familyInfoListTemp.addAll(familyInfoList);

        personInfoList.clear();
        familyInfoList.clear();

        myAdapter.notifyDataSetChanged();
    }

    private void setData() {
        personInfoList.clear();
        personInfoList.addAll(personInfoListTemp);

        familyInfoList.clear();
        familyInfoList.addAll(familyInfoListTemp);

        personInfoListTemp.clear();
        familyInfoListTemp.clear();

        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (listType == FuListFragment.EVENT_FAMILY) {
            Bundle bundle = new Bundle();
            bundle.putString("familyInfoId", familyInfoList.get(position).getFamilyInfoId());
            mEventCallBack.EventClick(FuListFragment.EVENT_FAMILY, bundle);
        } else {
            makeBottomDialog(position);
            showBottomDialog(position);
        }
    }

    class MyAdapter extends BaseAdapter {

        private Context context;
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {

            if (listType == FuListFragment.EVENT_FAMILY)
                return familyInfoList == null ? 0 : familyInfoList.size();
            else
                return personInfoList == null ? 0 : personInfoList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.fu_list_view_group_item,
                        null);
                holder = new Holder();
                holder.tv_num_sex = (FuTextView) convertView.findViewById(R.id.tv_num_sex);
                holder.tv_name = (FuTextView) convertView.findViewById(R.id.tv_name);
                holder.tv_age = (FuTextView) convertView.findViewById(R.id.tv_age);
                holder.tv_id = (FuTextView) convertView.findViewById(R.id.tv_id);
                holder.tv_address = (FuTextView) convertView.findViewById(R.id.tv_address);
//                holder.iv_right = (FuImageView) convertView.findViewById(R.id.iv_right);
                holder.view_2 = convertView.findViewById(R.id.view_2);
                holder.cb_old = (CircleButton) convertView.findViewById(R.id.cb_old);
                holder.cb_hyper = (CircleButton) convertView.findViewById(R.id.cb_hyper);
                holder.cb_diabetes = (CircleButton) convertView.findViewById(R.id.cb_diabetes);
                holder.cb_smi = (CircleButton) convertView.findViewById(R.id.cb_smi);
                convertView.setTag(holder);

            } else {
                holder = (Holder) convertView.getTag();
                holder.cb_old.setVisibility(View.GONE);
                holder.cb_hyper.setVisibility(View.GONE);
                holder.cb_diabetes.setVisibility(View.GONE);
                holder.cb_smi.setVisibility(View.GONE);
            }

            if (listType == FuListFragment.EVENT_FAMILY) {
                holder.tv_name.setText(familyInfoList.get(position).getHouseholder());
                holder.tv_num_sex.setText(familyInfoList.get(position).getFamilySize() + " 人");
                String no = familyInfoList.get(position).getHouseholderIdNo();
                if ("".equals(no) || no == null) {
                    holder.tv_id.setText("户主身份证号： 无");
                } else
                    holder.tv_id.setText("户主身份证号：" + no);
                holder.view_2.setVisibility(View.GONE);
                holder.tv_address.setText("地址：" + familyInfoList.get(position).getAddress());
            } else {
                //展示老高糖
                if (listType == FuListFragment.EVENT_PERSON) {
                    if (personInfoList.get(position).getIsElder() != null && 1 == personInfoList.get(position).getIsElder()) {
                        holder.cb_old.setVisibility(View.VISIBLE);
                    }
                    if (personInfoList.get(position).getIsHypertension() != null && 1 == personInfoList.get(position).getIsHypertension()) {
                        holder.cb_hyper.setVisibility(View.VISIBLE);
                    }
                    if (personInfoList.get(position).getIsDiabetes() != null && 1 == personInfoList.get(position).getIsDiabetes()) {
                        holder.cb_diabetes.setVisibility(View.VISIBLE);
                    }
                    if (personInfoList.get(position).getIsSmi() != null && 1 == personInfoList.get(position).getIsSmi()) {
                        holder.cb_smi.setVisibility(View.VISIBLE);
                    }
                }
                holder.tv_name.setText(personInfoList.get(position).getName());
                holder.tv_num_sex.setText(personInfoList.get(position).getSexValue());
                Date birthday = personInfoList.get(position).getBirthday();
                if (birthday == null) {

                } else {
                    holder.tv_age.setAge(birthday);
                }
                String no = personInfoList.get(position).getIdNo();
                if ("".equals(no) || no == null) {
                    holder.tv_id.setText("身份证号:  无");
                } else
                    holder.tv_id.setText("身份证号: " + no);
                holder.tv_address.setText("地址: " + personInfoList.get(position).getAddress());
            }
            return convertView;
        }

        class Holder {
            FuTextView tv_name;
            FuTextView tv_num_sex;
            FuTextView tv_age;
            FuTextView tv_id;
            FuTextView tv_address;
            FuImageView iv_right;
            View view_2;//第二条线
            CircleButton cb_old; //老年人
            CircleButton cb_hyper; //高血压
            CircleButton cb_diabetes; //糖尿病
            CircleButton cb_smi; //精神病
        }
    }




    public class PullToRefreshListener implements PullToRefreshLayout.OnRefreshListener {

        @Override
        public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {

            familyInfoList.clear();
            personInfoList.clear();

            myAdapter.notifyDataSetChanged();
            // 下拉刷新操作
            if (districtId == null) {
                districtId = TaskManager.getInstace().getDistrictId(mContext);
                districtLevel = Integer.parseInt(TaskManager.getInstace().getDistrictLev(mContext));
            }
            pageNo = 1;
            getData();

        }

        @Override
        public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
            // 加载操作
            if (districtId == null) {
                districtId = TaskManager.getInstace().getDistrictId(mContext);
                districtLevel = Integer.parseInt(TaskManager.getInstace().getDistrictLev(mContext));
            }
            pageNo++;
            getData();
        }

    }


    public void loadmoreFinish() {
        pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
    }

    public void refreshFinish() {
        pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
    }

    public boolean goBack() {
        if (ll_search.getVisibility() == View.VISIBLE) {
            ll_search.setVisibility(View.GONE);
            ll_main.setVisibility(View.VISIBLE);
            setData();
            return true;
        } else {
            return false;
        }
    }
}
