package net.greatsoft.main.uiframe;


import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.greatsoft.main.Constant;
import net.greatsoft.main.FuApp;
import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.helper.ALocalSqlHelper;
import net.greatsoft.main.db.helper.ChecksDao;
import net.greatsoft.main.db.helper.PersonDiseaseDao;
import net.greatsoft.main.db.helper.RecordChoiceDao;
import net.greatsoft.main.db.helper.SickChoiceMedicineDao;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.SickChoiceMedicine;
import net.greatsoft.main.db.po.SickMedicine;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowupDrug;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowupDrug;
import net.greatsoft.main.db.po.person.PersonDisease;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.db.po.person.PersonPastHistory;
import net.greatsoft.main.tool.ToastUtil;
import net.greatsoft.main.view.ElderInterFace;
import net.greatsoft.main.view.FuCheckBox;
import net.greatsoft.main.view.FuEditText;
import net.greatsoft.main.view.FuRadioButton;
import net.greatsoft.main.view.FuTextView;

import org.greenrobot.greendao.query.QueryBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class FuUiFrameModel {

    protected Context mContext;

    protected static int PAGE_SIZE = 10;

    protected FuEventCallBack mEventCallBack;

    ALocalSqlHelper sqlHelper;

    private Calendar m_Calendar;        //时间

    public FuUiFrameModel(Context cxt, FuEventCallBack callBack) {

        mContext = cxt;
        mEventCallBack = callBack;
        sqlHelper = ((FuApp) mContext.getApplicationContext()).getSqlHelper();
        createFuLayout();
        initWidget();
        initFuData();
    }


    protected View mFuView; // 对应的视图

    protected abstract void createFuLayout(); // 创建布局

    protected abstract void initFuData(); // 初始化基础数据和状态

    protected abstract void initWidget(); //初始化控件


    /**
     * 获取当前视图
     *
     * @return
     */
    public View getFuView() {

        return mFuView;
    }

    public void getMedicineList(String hyperId, String diabetesId, List<HyperFollowupDrug> list_hyperFollowupDrug, List<DiabetesFollowupDrug> list_diabetes2FollowupDrug,
                                LinearLayout ll) {
        for (int i = 0; i < ll.getChildCount(); i++) {
            View v = ll.getChildAt(i);
            if (v instanceof LinearLayout) {
                String medicine_id = "";
                String medicine_name = "";
                String medicine_times = "";
                String medicine_dosage = "";
                FuTextView tv_med = (FuTextView) v.findViewById(R.id.tv_med);
                Spinner sp_medicineTimes = (Spinner) v
                        .findViewById(R.id.sp_medicineTimes);
                FuEditText et_medicineDosage = (FuEditText) v
                        .findViewById(R.id.et_medicineDosage);
                if (tv_med.getTag() == null)
                    continue;
                medicine_id = ((SickMedicine) tv_med.getTag()).getSickMedicineId();
                medicine_name = ((SickMedicine) tv_med.getTag()).getName();
                medicine_times = ((Checks) sp_medicineTimes
                        .getSelectedItem()).getValue();
                medicine_dosage = et_medicineDosage.getText().toString().trim();

                SickChoiceMedicine sickChoiceMedicine = sqlHelper.getSickChoiceMedicineDao().queryBuilder().where(SickChoiceMedicineDao.Properties.SickMedicineId.eq(medicine_id)).list().get(0);

                if ("1".equals(sickChoiceMedicine.getSickCode())) {
                    DiabetesFollowupDrug diabetesFollowupDrug = new DiabetesFollowupDrug();
                    diabetesFollowupDrug.setDiabetesFollowupId(diabetesId);
                    diabetesFollowupDrug.setDrugId(medicine_id);
                    diabetesFollowupDrug.setDrugName(medicine_name);
                    diabetesFollowupDrug.setDrugUsingFreq(medicine_times);
                    diabetesFollowupDrug.setDrugPerDose(medicine_dosage);
                    list_diabetes2FollowupDrug.add(diabetesFollowupDrug);

                } else if ("2".equals(sickChoiceMedicine.getSickCode())) {
                    HyperFollowupDrug hyperFollowupDrug = new HyperFollowupDrug();
                    hyperFollowupDrug.setHyperFollowupId(hyperId);
                    hyperFollowupDrug.setDrugId(medicine_id);
                    hyperFollowupDrug.setDrugName(medicine_name);
                    hyperFollowupDrug.setDrugUsingFreq(medicine_times);
                    hyperFollowupDrug.setDrugPerDose(medicine_dosage);
                    list_hyperFollowupDrug.add(hyperFollowupDrug);
                }

            }
        }
    }


    /**
     * 人员标签  老年人, 孕妇,儿童,精神病,糖尿病
     */
    public void setTextType(PersonInfo personInfo, LinearLayout linearLayout) {
//       View view = null;

//        PersonTypeView personTypeView;

//        if(StringUtils.is(personInfo.getIsChild(),1)) {
//            personTypeView = new PersonTypeView(mContext);
//            personTypeView.setText("儿");
//            personTypeView.setColor(Color.BLACK);
//            personTypeView.setType(false);
//            linearLayout.addView(personTypeView);
//        }
//        if(StringUtils.is(personInfo.getIsMaternal(), 1)){
//            personTypeView = new PersonTypeView(mContext);
//            personTypeView.setText("孕");
//            personTypeView.setColor(Color.BLACK);
//            personTypeView.setType(false);
//            linearLayout.addView(personTypeView);
//        }
//        if(StringUtils.is(personInfo.getIsElder(), 1)){
//            personTypeView = new PersonTypeView(mContext);
//            personTypeView.setText("老");
//            personTypeView.setColor(Color.BLACK);
//            personTypeView.setType(false);
//            linearLayout.addView(personTypeView);
//        }
//        if(StringUtils.is(personInfo.getIsHypertension(),1)){
//            personTypeView = new PersonTypeView(mContext);
//            personTypeView.setText("高");
//            personTypeView.setColor(Color.BLACK);
//            personTypeView.setType(false);
//            linearLayout.addView(personTypeView);
//        }
//        if(StringUtils.is(personInfo.getIsDiabetes() ,1)){
//            personTypeView = new PersonTypeView(mContext);
//            personTypeView.setText("糖");
//            personTypeView.setColor(Color.BLACK);
//            personTypeView.setType(false);
//            linearLayout.addView(personTypeView);
//        }
//        if(StringUtils.is(personInfo.getIsSmi() , 1)){
//            personTypeView = new PersonTypeView(mContext);
//            personTypeView.setText("精");
//            personTypeView.setColor(Color.BLACK);
//            personTypeView.setType(false);
//            linearLayout.addView(personTypeView);
//        }
    }

    /**
     * 二级菜单
     */


    /**
     * @param str
     * @param layout
     */
    public void setText(String str, LinearLayout layout) {
        if (str == null)
            return;
        for (int i = 0; i < layout.getChildCount(); i++) {
            View v = layout.getChildAt(i);
            if (v instanceof FuEditText) {
                ((FuEditText) v).setText(str);
            } else if (v instanceof LinearLayout) {
                setText(str, (LinearLayout) v);
            }
        }
    }

    public void setText(Integer integer, LinearLayout layout) {
        if (integer == null)
            return;
        for (int i = 0; i < layout.getChildCount(); i++) {
            View v = layout.getChildAt(i);
            if (v instanceof FuEditText) {
                ((FuEditText) v).setText(integer);
            } else if (v instanceof LinearLayout) {
                setText(integer, (LinearLayout) v);
            }
        }
    }

    public void setDate(View v) {
        final TextView FuTextView = (TextView) v;

        m_Calendar = Calendar.getInstance();
        String o_date = FuTextView.getText().toString();
        if (!"".equals(o_date)) {
            m_Calendar.set(Calendar.YEAR,
                    Integer.parseInt(o_date.split("-")[0]));
            m_Calendar.set(Calendar.MONTH,
                    Integer.parseInt(o_date.split("-")[1]) - 1);
            m_Calendar.set(Calendar.DAY_OF_MONTH,
                    Integer.parseInt(o_date.split("-")[2]));
        }

        DatePickerDialog dialog = new DatePickerDialog(mContext,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        String t_date = year + "-" + (monthOfYear + 1)
                                + "-" + dayOfMonth;
                        FuTextView.setText(t_date);

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            Date date = sdf.parse(t_date);
                            FuTextView.setTag(date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }


                    }
                }, m_Calendar.get(Calendar.YEAR), m_Calendar
                .get(Calendar.MONTH), m_Calendar
                .get(Calendar.DAY_OF_MONTH));
        DatePicker dp = dialog.getDatePicker();

        dp.setMinDate(-5364691200000L);
        dialog.show();
    }

    public Integer getInt(LinearLayout linearLayout) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View v = linearLayout.getChildAt(i);
            if (v instanceof FuEditText) {
                String text = ((FuEditText) v).getText().toString().trim();
                if (isNumeric(text))
                    return Integer.parseInt(text);
            } else if (v instanceof LinearLayout) {
                Integer integer = getInt((LinearLayout) v);
                if (integer != null)
                    return integer;
            }
        }
        return null;
    }

    public String getString(LinearLayout linearLayout) {
        String text = null;
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View v = linearLayout.getChildAt(i);
            if (v instanceof FuEditText) {
                text = ((FuEditText) v).getText().toString().trim();
                return text;
            } else if (v instanceof LinearLayout) {
                text = getString((LinearLayout) v);
            }
        }
        return text;
    }

    public String getRadioString(LinearLayout linearLayout) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View v = linearLayout.getChildAt(i);
            if (v instanceof FuEditText) {
                String text = ((FuEditText) v).getText().toString().trim();
                return text;
            } else if (v instanceof RadioButton) {
                if (((RadioButton) v).isChecked())
                    return ((RadioButton) v).getText().toString().trim();
            } else if (v instanceof LinearLayout) {
                return getRadioString((LinearLayout) v);
            }
        }
        return null;
    }

    public boolean isNumeric(String str) {
        return str.matches("-?[0-9]+.*[0-9]*");
    }

    /**
     * @param code    代码值
     * @param spinner sp
     */
    public void setSpinnerSelected(String type, String code, Spinner spinner) {
        if (code == null || type == null || spinner == null)
            return;
        int ips = 0;
        List list = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq(type)).orderAsc(ChecksDao.Properties.Code).list();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Checks bo = (Checks) list.get(i);
                if (code.equals(bo.getCode())) {
                    ips = i;
                    break;
                }
            }
        }
        spinner.setSelection(ips, true);
    }


    /**
     * @param code    代码值
     * @param spinner sp
     */
    public void setSpinnerSelectedByTerm(String type, String code, Spinner spinner) {
        if (code == null || type == null || spinner == null)
            return;
        int ips = 0;
        List list = sqlHelper.getChecksByTerm(type);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Checks bo = (Checks) list.get(i);
                if (code.equals(bo.getCode())) {
                    ips = i;
                    break;
                }
            }
        }
        spinner.setSelection(ips, true);
    }



    /**
     * 设置疾病
     *
     * @param alist
     * @param cb
     * @param et_confirmDate
     * @param et_name
     */
    public void setPersonDisease(ArrayList<PersonDisease> alist,
                                 CheckBox cb, FuEditText et_confirmDate, FuEditText et_name) {
        if (alist != null && alist.size() > 0) {
            PersonDisease personDisease = alist.get(0);
            cb.setChecked(true);
            if (et_name != null) {
                et_name.setText(personDisease.getDiseaseName());
            }
            et_confirmDate.setText(personDisease.getConfirmDate());
        } else {
            cb.setChecked(false);
        }
    }


    /**
     * 保存疾病
     *
     * @param alist
     * @param cb
     * @param et_confirmDate
     * @param et_name
     */
    public void getPersonDisease(String psersonInfoId, List<PersonDisease> alist,
                                 CheckBox cb, FuEditText et_confirmDate, FuEditText et_name) {
        if (cb.isChecked()) {
            PersonDisease po = new PersonDisease();
//            po.setPersonDiseaseId(UUID.randomUUID().toString().replaceAll("-", ""));
//            po.setPersonInfoId(psersonInfoId);
            po.setDiseaseCode(cb.getTag().toString());
            if (et_name == null)
                po.setDiseaseName(cb.getText().toString());
            else
                po.setDiseaseName(et_name.getString());
            if (et_confirmDate != null)
                po.setConfirmDate(et_confirmDate.getInt());
            alist.add(po);
        }
    }


    /**
     * 获取选择框值（选择框-单选）
     **/
    public static String getCheckBoxSimpleCode(LinearLayout para1) {
        String backstr = "";
        for (int i = 0; i < para1.getChildCount(); i++) {
            View v = para1.getChildAt(i);
            if (v instanceof RadioButton) {
                if (((CompoundButton) v).isChecked()) {
                    backstr = ((Checks) v.getTag()).getCode();
                }
            } else if (v instanceof LinearLayout) {
                for (int j = 0; j < ((ViewGroup) v).getChildCount(); j++) {
                    View w = ((ViewGroup) v).getChildAt(j);
                    if (w instanceof RadioButton) {
                        if (((CompoundButton) w).isChecked()) {
                            backstr = ((Checks) w.getTag()).getCode();
                        }
                    }
                }
            }
        }
        return backstr;
    }

    /**
     * 获取选择框值（选择框-单选）
     **/
    public static String getCheckBoxSimpleString(LinearLayout para1) {
        String backstr = "";
        for (int i = 0; i < para1.getChildCount(); i++) {
            View v = para1.getChildAt(i);
            if (v instanceof RadioButton) {
                if (((CompoundButton) v).isChecked()) {
                    backstr = ((Checks) v.getTag()).getValue();
                }
            } else if (v instanceof LinearLayout) {
                for (int j = 0; j < ((ViewGroup) v).getChildCount(); j++) {
                    View w = ((ViewGroup) v).getChildAt(j);
                    if (w instanceof RadioButton) {
                        if (((CompoundButton) w).isChecked()) {
                            backstr = ((Checks) w.getTag()).getValue();
                        }
                    } else if (v instanceof FuEditText) {
                        backstr = ((FuEditText) v).getString();
                    }
                }
            } else if (v instanceof FuEditText) {
                backstr = ((FuEditText) v).getString();
            }
        }
        return backstr;
    }

    /**
     * 获取linearlayout中的edittext 值（选择框-单选）
     **/
    public static String getLinearLayoutString(LinearLayout para1) {
        String backstr = "";
        for (int i = 0; i < para1.getChildCount(); i++) {
            View v = para1.getChildAt(i);
            if (v instanceof FuEditText) {
                backstr = ((FuEditText) v).getString();
            } else if (v instanceof LinearLayout) {
                for (int j = 0; j < ((ViewGroup) v).getChildCount(); j++) {
                    View w = ((ViewGroup) v).getChildAt(j);
                    if (w instanceof FuEditText) {
                        backstr = ((FuEditText) w).getString();
                    }
                }
            }
        }
        return backstr;
    }

    /**
     * 设置既往史手术、外伤、输血信息
     **/
    public void setPersonPastHistory(List<PersonPastHistory> para1,
                                     RadioButton cb1, RadioButton cb2, FuEditText et1, FuEditText et2,
                                     FuEditText et3, FuEditText et4) {

        PersonPastHistory bo;
        if (para1 != null && para1.size() > 0) {
            bo = para1.get(0);
            if ("1".equals(bo.getChoiceStatus())) {
                cb1.setChecked(true);
            }
            if ("2".equals(bo.getChoiceStatus())) {
                cb2.setChecked(true);
                et1.setText(bo.getHistoryName());
                et2.setText(bo.getConfirmDate(), null);

                bo = para1.get(1);
                et3.setText(bo.getHistoryName());
                et4.setText(bo.getConfirmDate(), null);
            }
        }
    }

    /**
     * 设置既往史手术、外伤、输血信息
     **/
    public void setPersonPastHistory(PersonPastHistory para1,
                                     RadioButton cb1, RadioButton cb2, FuEditText et1, FuEditText et2) {

        if ("1".equals(para1.getChoiceStatus())) {
            cb1.setChecked(true);
        }
        if ("2".equals(para1.getChoiceStatus())) {
            cb2.setChecked(true);
            et1.setText(para1.getHistoryName());
            et2.setText(para1.getConfirmDate());

        }
    }

    /**
     * 保存既往史手术、外伤、输血信息
     **/
    public boolean getPersonPastHistory(String personInfoId, List<PersonPastHistory> alist,
                                        String type, RadioButton cb1, RadioButton cb2, FuEditText et1,
                                        FuEditText et2, FuEditText et3, FuEditText et4) {


        PersonPastHistory po;
        if (cb1.isChecked()) {
            po = new PersonPastHistory();
//            po.setPersonPastHistoryId(UUID.randomUUID().toString().replaceAll("-", ""));
//            po.setPersonInfoId(personInfoId);
            po.setHistoryType(type);
            po.setChoiceStatus("1");
            po.setOrderNo(1);
            alist.add(po);

            po = new PersonPastHistory();
//            po.setPersonPastHistoryId(UUID.randomUUID().toString().replaceAll("-", ""));
//            po.setPersonInfoId(personInfoId);
            po.setHistoryType(type);
            po.setOrderNo(2);
            po.setChoiceStatus("1");
            alist.add(po);
        }
        if (cb2.isChecked()) {
            po = new PersonPastHistory();
//            po.setPersonPastHistoryId(UUID.randomUUID().toString().replaceAll("-", ""));
//            po.setPersonInfoId(personInfoId);
            po.setHistoryType(type);
            po.setChoiceStatus("2");
            po.setHistoryName(et1.getText().toString());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
            String s = et2.getText().toString();
            if (!"".equals(s)) {
                if (s.length() != 6) {
                    ToastUtil.showToast(mContext, "请输入正确时间", Toast.LENGTH_LONG);
                    return false;
                } else {
                    int i1 = Integer.parseInt(s.substring(0, 4));
                    int i2 = Integer.parseInt(s.substring(4, 6));
                    if (i1 > 1900 && i1 < 2100 && i2 > 0 && i2 < 13) {
                        try {
                            Date parse = dateFormat.parse(s);
                            po.setConfirmDate(parse);
                        } catch (ParseException e) {
                            ToastUtil.showToast(mContext, "请输入正确时间", Toast.LENGTH_LONG);
                            return false;
                        }
                    } else {
                        ToastUtil.showToast(mContext, "请输入正确时间", Toast.LENGTH_LONG);
                        return false;
                    }
                }
            }

            po.setOrderNo(1);
            alist.add(po);

            po = new PersonPastHistory();
//            po.setPersonPastHistoryId(UUID.randomUUID().toString().replaceAll("-", ""));
//            po.setPersonInfoId(personInfoId);
            po.setHistoryType(type);
            po.setChoiceStatus("2");
            po.setHistoryName(et3.getText().toString());
            s = et4.getText().toString();
            if (!"".equals(s)) {
                if (s.length() != 6) {
                    ToastUtil.showToast(mContext, "请输入正确时间", Toast.LENGTH_LONG);
                    return false;
                } else {
                    int i1 = Integer.parseInt(s.substring(0, 4));
                    int i2 = Integer.parseInt(s.substring(4, 6));
                    if (i1 > 1900 && i1 < 2100 && i2 > 0 && i2 < 13) {
                        try {
                            Date parse = dateFormat.parse(s);
                            po.setConfirmDate(parse);
                        } catch (ParseException e) {
                            ToastUtil.showToast(mContext, "请输入正确时间", Toast.LENGTH_LONG);
                            return false;
                        }
                    } else {
                        ToastUtil.showToast(mContext, "请输入正确时间", Toast.LENGTH_LONG);
                        return false;
                    }
                }
            }
            po.setOrderNo(2);
            alist.add(po);
        }

        return true;
    }


    /**
     * 获取选择框代码值（选择框-多选）
     **/
    public static void saveCheckBoxMany(String tableKey, List<RecordChoice> list, LinearLayout linearLayout) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View v = linearLayout.getChildAt(i);
            if (v instanceof CheckBox) {
                if (((CompoundButton) v).isChecked()) {
                    Checks c = (Checks) v.getTag();
                    RecordChoice rc = new RecordChoice();
                    rc.setCode(c.getCode());
                    rc.setCodeType(c.getType());
                    rc.setName(c.getValue());
                    View ed = linearLayout.getChildAt((i + 1));
                    if (ed != null && ed instanceof FuEditText)
                        rc.setName(((FuEditText) ed).getText().toString());

                    rc.setTableKey(tableKey);
                    list.add(rc);
                }
            } else if (v instanceof LinearLayout) {
                saveCheckBoxMany(tableKey, list, ((LinearLayout) v));
            }
        }
    }

    /**
     * 设置既往史疾病信息 参数：para1为待匹配值-多个值；para2为CheckBox的父布局
     **/
    public void setPersonDisease(String persionId, String diseaseCode,
                                 CheckBox para2, FuEditText et_name, FuEditText et_date) {

        List<PersonDisease> para1 = sqlHelper.getPersonDiseaseDao().queryBuilder().where(PersonDiseaseDao.Properties.PersonInfoId.eq(persionId), PersonDiseaseDao.Properties.DiseaseCode.eq(diseaseCode)).list();
        if (para1 != null && para1.size() > 0) {
            PersonDisease bo = para1.get(0);
            para2.setChecked(true);
            if (et_name != null) {
                et_name.setText(bo.getDiseaseName());
            }
            if (et_date != null)
                et_date.setText(bo.getConfirmDate());
        } else {
            para2.setChecked(false);
        }
    }

    /**
     * 设置既往史疾病信息 参数：para1为待匹配值-多个值；para2为CheckBox的父布局
     **/
    public void setPersonDisease(List<PersonDisease> para1, String diseaseCode,
                                 CheckBox para2, FuEditText et_name, FuEditText et_date) {

        for (int i = 0; i < para1.size(); i++) {
            if (para1.get(i).getDiseaseCode().equals(para2.getTag())) {
                para2.setChecked(true);
                if (et_name != null) {
                    et_name.setText((para1.get(i).getDiseaseName()));
                }
                if (et_date != null)
                    et_date.setText((para1.get(i).getConfirmDate()));
                return;
            }
        }
    }


    /**
     * 设置选定（选择框-单选） 参数：para1为待匹配值-单个值；para2为CheckBox的父布局
     **/
    public void setRadioButtonSelect(String para1, String name, LinearLayout para2) {
        if (para1 != null && !"".equals(para1)) {
            for (int i = 0; i < para2.getChildCount(); i++) {
                View v = para2.getChildAt(i);
                if (v instanceof CompoundButton) {
                    if (para1.equals(((Checks) v.getTag()).getCode())) {
                        ((CompoundButton) v).setChecked(true);
                    }
                } else if (v instanceof LinearLayout) {
                    setRadioButtonSelect(para1, name, (LinearLayout) v);
                } else if (v instanceof FuEditText) {
                    ((FuEditText) v).setText(name);
                }
            }
        }
    }

    /**
     * 设置选定（选择框-单选） 参数：para1为待匹配值-单个值；para2为CheckBox的父布局
     **/
    public void setCheckBoxSelect(String para1, LinearLayout para2) {
        if (para1 != null && !"".equals(para1)) {
            for (int i = 0; i < para2.getChildCount(); i++) {
                View v = para2.getChildAt(i);
                if (v instanceof CompoundButton) {
                    if (para1.equals(((Checks) v.getTag()).getCode())) {
                        ((CompoundButton) v).setChecked(true);
                    }
                } else if (v instanceof LinearLayout) {
                    setCheckBoxSelect(para1, (LinearLayout) v);
                }
            }
        }
    }

    /**
     * 设置选定（选择框-单选） 参数：para1为待匹配值-单个值；para2为CheckBox的父布局
     **/
    public void setCheckBoxTwoSelect(String para1, String para2, LinearLayout linearLayout) {
        if (para1 != null && !"".equals(para1)) {
            setCheckBoxSelect(para1, linearLayout);
        } else if (para2 != null && !"".equals(para2)) {
            setCheckBoxSelect(para2, linearLayout);
        }
    }

    /**
     * 设置选定（选择框-多选）
     *
     * @param codeType 代码值
     * @param tableKey 主键
     * @param layout   容器
     */
    public void setCheckBoxSelect(String codeType, String tableKey, LinearLayout layout) {
        QueryBuilder queryBuilder = sqlHelper.getRecordChoiceDao().queryBuilder();
        List<RecordChoice> list_recordChoice = queryBuilder.where(RecordChoiceDao.Properties.CodeType.eq(codeType), RecordChoiceDao.Properties.TableKey.eq(tableKey)).list();

        setCheckBoxSelect(list_recordChoice, layout);
    }

    /**
     * 网络使用的设置
     *
     * @param codeType
     * @param list_recordChoice
     * @param layout
     */
    public void setCheckBoxSelect(String codeType, List<RecordChoice> list_recordChoice, LinearLayout layout) {
        String otherName = null;
        if (list_recordChoice != null && list_recordChoice.size() > 0) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View v = layout.getChildAt(i);
                if (v instanceof CheckBox) {
                    for (int x = 0; x < list_recordChoice.size(); x++) {
                        String code = list_recordChoice.get(x).getCode();
                        String name = list_recordChoice.get(x).getName();
                        String type = list_recordChoice.get(x).getCodeType();
                        if (code.equals(((Checks) v.getTag()).getCode()) && codeType.equals(type)) {
                            ((CompoundButton) v).setChecked(true);
                            if (!name.equals(((CheckBox) v).getText())) {
                                otherName = name;
                            }
                            break;
                        }

                    }
                } else if ((v instanceof FuEditText) && (otherName != null)) {
                    ((FuEditText) v).setText(otherName);
                } else if (v instanceof LinearLayout) {
                    setCheckBoxSelect(codeType, list_recordChoice, (LinearLayout) v);
                }
            }
        }
    }


    public void setCheckBoxSelect(List<RecordChoice> list_recordChoice, LinearLayout layout) {
        String otherName = null;
        if (list_recordChoice != null && list_recordChoice.size() > 0) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View v = layout.getChildAt(i);
                if (v instanceof CheckBox) {
                    for (int x = 0; x < list_recordChoice.size(); x++) {
                        String code = list_recordChoice.get(x).getCode();
                        String name = list_recordChoice.get(x).getName();
                        if (code.equals(((Checks) v.getTag()).getCode())) {
                            ((CompoundButton) v).setChecked(true);
                            if (!name.equals(((CheckBox) v).getText())) {
                                otherName = name;
                            }
                            break;
                        }


                    }
                } else if ((v instanceof FuEditText) && (otherName != null)) {
                    ((FuEditText) v).setText(otherName);
                } else if (v instanceof LinearLayout) {
                    setCheckBoxSelect(list_recordChoice, (LinearLayout) v);
                }
            }
        }
    }

    public void initCheckBoxMany(String para1, LinearLayout para2, int linenum) {
        initCheckBoxMany(para1, para2, linenum, false, false);
    }

    public void initCheckBoxMany(String para1, LinearLayout para2, int linenum,
                                 boolean flag) {
        initCheckBoxMany(para1, para2, linenum, flag, false);
    }

    public void setRadioOrCheckBoxEnabel(LinearLayout ll) {
        if (ll == null) {
            return;
        }
        for (int i = 0; i < ll.getChildCount(); i++) {
            if (ll.getChildAt(i) instanceof RadioButton) {
                ((RadioButton) ll.getChildAt(i)).setEnabled(false);
                ((RadioButton) ll.getChildAt(i)).setTextColor(mContext.getResources().getColor(R.color.text_enble));
            } else if (ll.getChildAt(i) instanceof CheckBox) {
                ((CheckBox) ll.getChildAt(i)).setEnabled(false);
                ((CheckBox) ll.getChildAt(i)).setTextColor(mContext.getResources().getColor(R.color.text_enble));
            } else if (ll.getChildAt(i) instanceof FuEditText) {
                ((FuEditText) ll.getChildAt(i)).setEnabled(false);
            } else if (ll.getChildAt(i) instanceof LinearLayout) {
                setRadioOrCheckBoxEnabel(((LinearLayout) ll.getChildAt(i)));
            }
        }
    }

    /**
     * @param para1    数据类型
     * @param para2    父布局id
     * @param linenum  每行显示数量
     * @param flag     是否有默认值
     * @param editflag 是否有输入框
     */
    public void initCheckBoxMany(String para1, LinearLayout para2, int linenum,
                                 boolean flag, boolean editflag) {
//		List<Checks> list1 = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq(para1)).orderAsc(ChecksDao.Properties.Code).list();
        List<Checks> list1 = sqlHelper.getChecksDao().queryRaw(" WHERE T.TYPE = '" + para1 + "' order by cast(code as integer) ", new String[]{});


        if (list1.size() >= linenum) {
            LinearLayout ll = new LinearLayout(mContext);
            LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            lp.gravity = Gravity.RIGHT;
            lp.setMargins(0, 10, 0, 10);
            ll.setLayoutParams(lp);

            for (int i = 0; i < list1.size(); i++) {
                if (i % linenum == 0) {
                    ll = new LinearLayout(mContext);
                    ll.setLayoutParams(lp);

                    ll.setMinimumHeight(mContext.getResources().getDimensionPixelSize(R.dimen.min_heath));
                    para2.addView(ll);
                }

                Checks po = list1.get(i);
                View v = LayoutInflater.from(mContext).inflate(R.layout.fu_checkbox, null);
                FuCheckBox cb = (FuCheckBox) v;
                cb.setTextColor(Color.BLACK);
                cb.setId(Constant.EXAM_ID++);
                cb.setText(po.getValue());
                cb.setTag(po);
                if (flag) {
                    if ("1".equals(po.getIsDefault())) {
                        cb.setChecked(true);
                    }
                }
                ll.addView(cb);

            }
            if (editflag) {
                FuEditText et = new FuEditText(mContext);
                et.setId(Constant.EXAM_ID++);
                et.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0f));
                et.setSingleLine(true);
                ll.addView(et);
            }
        }
    }

    public void initCheckBoxSimple(String para1, final LinearLayout para2,
                                   int linenum) {
        initCheckBoxSimple(para1, para2, linenum, false, false, false);
    }

    public void initCheckBoxSimple(String para1, final LinearLayout para2,
                                   int linenum, boolean updateFlag) {
        initCheckBoxSimple(para1, para2, linenum, updateFlag, false, false);
    }

    public void initCheckBoxSimple(String para1, final LinearLayout para2,
                                   int linenum, boolean updateFlag, boolean editflag) {
        initCheckBoxSimple(para1, para2, linenum, updateFlag, editflag, false);
    }

    /**
     * 单选
     *
     * @param para1      基础数据类型
     * @param para2      CheckBox的父布局的ID
     * @param linenum    每行显示数量
     * @param updateFlag 是否默认值
     * @param editflag   是否生成编辑项
     * @param isNum      是否是数字
     */
    public void initCheckBoxSimple(String para1, final LinearLayout para2,
                                   int linenum, boolean updateFlag, boolean editflag, boolean isNum) {
        QueryBuilder queryBuilder = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq(para1)).orderAsc(ChecksDao.Properties.SerialNumber);
        List<Checks> list1 = queryBuilder.list();
        if (list1.size() >= linenum && linenum > 0) {
            LinearLayout ll = new LinearLayout(mContext);
            ll.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            ll.setMinimumHeight(mContext.getResources().getDimensionPixelSize(R.dimen.min_heath));
            ll.setOrientation(LinearLayout.HORIZONTAL);
            for (int i = 0; i < list1.size(); i++) {
                para2.refreshDrawableState();
                if (i % linenum == 0) {
                    ll = new LinearLayout(mContext);

                    LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                    lp.gravity = Gravity.RIGHT;
                    lp.setMargins(0, 10, 0, 10);

                    ll.setLayoutParams(lp);
                    ll.setGravity(Gravity.CENTER_VERTICAL);
                    ll.setOrientation(LinearLayout.HORIZONTAL);


                    para2.addView(ll);
                }

                Checks po = list1.get(i);
//                FuRadioButton cb = new FuRadioButton(mContext);

                View v = LayoutInflater.from(mContext).inflate(R.layout.fu_radiobutton, null);
                FuRadioButton cb = (FuRadioButton) v;

                cb.setTextColor(Color.BLACK);
                cb.setText(po.getValue());
                cb.setTag(po);
                cb.setId(Constant.EXAM_ID++);
                if (updateFlag) {
                    if ("1".equals(po.getIsDefault())) {
                        cb.setChecked(true);
                    }
                }

                ll.addView(cb);

                cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        // 做单选处理
                        if (isChecked) {
                            for (int x = 0; x < para2.getChildCount(); x++) {
                                View w = para2.getChildAt(x);
                                if (w instanceof LinearLayout) {
                                    for (int y = 0; y < ((ViewGroup) w)
                                            .getChildCount(); y++) {
                                        View v = ((ViewGroup) w).getChildAt(y);
                                        if (v instanceof RadioButton) {
                                            if (!buttonView.getTag().equals(
                                                    ((CompoundButton) v)
                                                            .getTag())) {
                                                ((CompoundButton) v)
                                                        .setChecked(false);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }
            if (editflag) {
                FuEditText et = new FuEditText(mContext);
                et.setSingleLine(true);
                et.setId(Constant.EXAM_ID++);
                et.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0f));
                if (isNum) {
                    et.setInputType(InputType.TYPE_CLASS_NUMBER);
                }
                ll.addView(et);
            }

        } else {
            initCheckBoxSimple(para1, para2, editflag);
        }
    }

    /**
     * radiobutton 增加change事件
     *
     * @param para1
     * @param para2
     * @param checkedChangeListener
     */
    public void initCheckBoxSimple(String para1, final LinearLayout para2, CompoundButton.OnCheckedChangeListener checkedChangeListener) {

        List<Checks> list1 = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq(para1)).orderAsc(ChecksDao.Properties.SerialNumber).list();
        para2.refreshDrawableState();
        for (int i = 0; i < list1.size(); i++) {
            Checks po = list1.get(i);
            View v = LayoutInflater.from(mContext).inflate(R.layout.fu_radiobutton, null);
            FuRadioButton cb = (FuRadioButton) v;
            cb.setTextColor(Color.BLACK);
            cb.setText(po.getValue());
            cb.setGravity(Gravity.CENTER_VERTICAL);
            cb.setTag(po);
            cb.setId(Constant.EXAM_ID++);
            if ("1".equals(po.getIsDefault())) {
                cb.setChecked(true);
            }
            cb.setOnCheckedChangeListener(checkedChangeListener);
            para2.addView(cb);

        }
    }

    /**
     * 初始化数据（RadioButotn-单选） 参数：para1为基础数据类型 ；para2为CheckBox的父布局的ID
     * ；para3为CheckBox的父布局
     **/
    public void initCheckBoxSimple(String para1, final LinearLayout para2, boolean editflag) {
        List<Checks> list1 = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq(para1)).orderAsc(ChecksDao.Properties.SerialNumber).list();
        para2.refreshDrawableState();
        for (int i = 0; i < list1.size(); i++) {
            Checks po = list1.get(i);
            View v = LayoutInflater.from(mContext).inflate(R.layout.fu_radiobutton, null);
            FuRadioButton cb = (FuRadioButton) v;
            cb.setTextColor(Color.BLACK);
            cb.setText(po.getValue());
            cb.setGravity(Gravity.CENTER_VERTICAL);
            cb.setTag(po);
            cb.setId(Constant.EXAM_ID++);
            if ("1".equals(po.getIsDefault())) {
                cb.setChecked(true);
            }
            para2.addView(cb);

            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    // 做单选处理
                    if (isChecked) {
                        for (int x = 0; x < para2.getChildCount(); x++) {
                            View v = para2.getChildAt(x);
                            if (v instanceof RadioButton) {
                                if (!buttonView.getTag().equals(
                                        ((CompoundButton) v).getTag())) {
                                    ((CompoundButton) v).setChecked(false);
                                }
                            }
                        }
                    }
                }
            });
        }
        if (editflag) {
            FuEditText et = new FuEditText(mContext);
            et.setWidth(100);
            et.setSingleLine(true);
            et.setId(Constant.EXAM_ID++);
            et.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0f));
            para2.addView(et);
        }
    }

    /**
     * 单选
     *
     * @param para1   基础数据类型
     * @param para2   CheckBox的父布局的ID
     * @param linenum 每行显示数量
     */
    public void initCheckBoxSimpleElder(String para1, final LinearLayout para2,
                                        int linenum, final ElderInterFace elderInterFace, boolean edit) {
        QueryBuilder queryBuilder = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq(para1)).orderAsc(ChecksDao.Properties.SerialNumber);
        List<Checks> list1 = queryBuilder.list();
        if (list1.size() >= linenum && linenum > 0) {
            LinearLayout ll = new LinearLayout(mContext);
            ll.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            ll.setMinimumHeight(mContext.getResources().getDimensionPixelSize(R.dimen.min_heath));
            ll.setOrientation(LinearLayout.HORIZONTAL);
            for (int i = 0; i < list1.size(); i++) {
                para2.refreshDrawableState();
                if (i % linenum == 0) {
                    ll = new LinearLayout(mContext);
                    LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                    lp.gravity = Gravity.RIGHT;
                    lp.setMargins(0, 10, 0, 10);
                    ll.setLayoutParams(lp);
                    ll.setGravity(Gravity.CENTER_VERTICAL);
                    ll.setOrientation(LinearLayout.HORIZONTAL);
                    para2.addView(ll);
                }

                Checks po = list1.get(i);
//                FuRadioButton cb = new FuRadioButton(mContext);

                View v = LayoutInflater.from(mContext).inflate(R.layout.fu_radiobutton, null);
                FuRadioButton cb = (FuRadioButton) v;

                cb.setTextColor(Color.BLACK);
                cb.setText(po.getValue());
                cb.setTag(po);
                cb.setId(Constant.EXAM_ID++);

                ll.addView(cb);

                cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        // 做单选处理
                        if (isChecked) {
                            for (int x = 0; x < para2.getChildCount(); x++) {
                                View w = para2.getChildAt(x);
                                if (w instanceof LinearLayout) {
                                    for (int y = 0; y < ((ViewGroup) w)
                                            .getChildCount(); y++) {
                                        View v = ((ViewGroup) w).getChildAt(y);
                                        if (v instanceof RadioButton) {
                                            if (!buttonView.getTag().equals(
                                                    ((CompoundButton) v)
                                                            .getTag())) {
                                                ((CompoundButton) v)
                                                        .setChecked(false);
                                            }
                                        }
                                    }
                                }
                            }
                            elderInterFace.onChangeEvent();
                        }
                    }
                });
            }
        } else {
            para2.refreshDrawableState();
            for (int i = 0; i < list1.size(); i++) {
                Checks po = list1.get(i);
                View v;
                if (i == 0)
                    v = LayoutInflater.from(mContext).inflate(R.layout.fu_noback_radiobutton, null);
                else
                    v = LayoutInflater.from(mContext).inflate(R.layout.fu_radiobutton, null);
                FuRadioButton cb = (FuRadioButton) v;
                cb.setTextColor(Color.BLACK);
                cb.setText(po.getValue());
                cb.setGravity(Gravity.CENTER_VERTICAL);
                cb.setTag(po);
                cb.setId(Constant.EXAM_ID++);
                cb.setEnabled(false);
                para2.addView(cb);
                if (i == 0 && edit) {
                    FuEditText et = new FuEditText(mContext);
                    et.setWidth(100);
                    et.setBackgroundResource(R.drawable.bg_corner);
                    et.setId(Constant.EXAM_ID++);
                    et.setSingleLine(true);
                    et.setEnabled(false);
                    para2.addView(et);
                }
                cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        // 做单选处理
                        if (isChecked) {
                            for (int x = 0; x < para2.getChildCount(); x++) {
                                View v = para2.getChildAt(x);
                                if (v instanceof RadioButton) {
                                    if (!buttonView.getTag().equals(
                                            ((CompoundButton) v).getTag())) {
                                        ((CompoundButton) v).setChecked(false);
                                    }
                                }
                            }
                        }
                    }
                });
            }


        }
    }


    /**
     * 设置选定（选择框-单选） 参数：para1为待匹配值-单个值；para2为CheckBox的父布局
     **/
    public void setCheckBoxSelectElder(String para1, int code, LinearLayout para2) {
        if (para1 != null && !"".equals(para1)) {
            for (int i = 0; i < para2.getChildCount(); i++) {
                View v = para2.getChildAt(i);
                if (v instanceof CompoundButton) {
                    if (para1.equals(((Checks) v.getTag()).getCode())) {
                        ((CompoundButton) v).setChecked(true);
                    }
                } else if (v instanceof FuEditText) {
                    ((FuEditText) v).setText(code + "");
                }
            }
        }
    }

    /**
     * @param codeType
     * @param layout
     */
    public void setCheckBoxSelectElder(String codeType, LinearLayout layout) {

        for (int i = 0; i < layout.getChildCount(); i++) {
            View v = layout.getChildAt(i);
            if (v instanceof CheckBox) {
                if ("2".equals(codeType) || "3".equals(codeType)) {
                    Checks checks = (Checks) v.getTag();
                    if ("1".equals(checks.getCode()) || "2".equals(checks.getCode()) || "3".equals(checks.getCode()) || "4".equals(checks.getCode()))
                        ((CheckBox) v).setChecked(true);
                } else {
                    ((CheckBox) v).setChecked(false);
                }
            } else if (v instanceof LinearLayout) {
                setCheckBoxSelectElder(codeType, (LinearLayout) v);
            }
        }
    }



}
