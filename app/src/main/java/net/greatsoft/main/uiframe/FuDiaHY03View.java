package net.greatsoft.main.uiframe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import net.greatsoft.main.R;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.db.helper.ChecksDao;
import net.greatsoft.main.db.helper.DiabetesFollowupDrugDao;
import net.greatsoft.main.db.helper.HyperFollowupDrugDao;
import net.greatsoft.main.db.helper.SickMedicineDao;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.SickMedicine;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowup;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowupDrug;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowup;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowupDrug;
import net.greatsoft.main.view.FuEditText;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglin on 16/8/3.
 */
public class FuDiaHY03View extends FuUiFrameModel implements View.OnClickListener {

    LinearLayout ll_medicine;       //药品
    ImageButton ib_add;             //增加
    GridView gv_o_medicine;         //过去的
    Button btn_next;
    List<Checks> list_yf;       //用法
    List<SickMedicine> list_sickMedicine;//药品

    List<DiabetesFollowupDrug> list_diabetesFollowupDrug;//糖尿病用药从表
    List<HyperFollowupDrug> list_hyperFollowupDrug;//高血压用药从表

    int index_id;

    public FuDiaHY03View(Context cxt, FuEventCallBack callBack) {
        super(cxt, callBack);
    }

    @Override
    protected void createFuLayout() {
        index_id = 500;

        mFuView = LayoutInflater.from(mContext).inflate(
                R.layout.diahy_fragment03, null);
    }

    @Override
    protected void initFuData() {
        list_yf = sqlHelper.getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq("MEDICINE_TIMES")).list();
        list_sickMedicine = sqlHelper.getSickMedicineDao().loadAll();
    }


    public void setError() {
    }

    @Override
    protected void initWidget() {
        ll_medicine = (LinearLayout) mFuView.findViewById(R.id.ll_medicine);
        ib_add = (ImageButton) mFuView.findViewById(R.id.ib_add);
        gv_o_medicine = (GridView) mFuView.findViewById(R.id.gv_o_medicine);
        btn_next = (Button) mFuView.findViewById(R.id.btn_next);

        ib_add.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_add:
                addYY();
                break;
        }
    }


    public void saveData(HyperFollowup hyperFollowup, DiabetesFollowup diabetesFollowup) {
        List<HyperFollowupDrug> list_hyperFollowupDrug = new ArrayList<>();
        List<DiabetesFollowupDrug> list_diabetesFollowupDrug = new ArrayList<>();
        getMedicineList(hyperFollowup.getHyperFollowupId(), diabetesFollowup.getDiabetesFollowupId(), list_hyperFollowupDrug, list_diabetesFollowupDrug, ll_medicine);
        sqlHelper.getDiabetesFollowupDrugDao().queryBuilder().where(DiabetesFollowupDrugDao.Properties.DiabetesFollowupId.eq(diabetesFollowup.getDiabetesFollowupId())).buildDelete().executeDeleteWithoutDetachingEntities();
        sqlHelper.getHyperFollowupDrugDao().queryBuilder().where(HyperFollowupDrugDao.Properties.HyperFollowupId.eq(hyperFollowup.getHyperFollowupId())).buildDelete().executeDeleteWithoutDetachingEntities();

        sqlHelper.getDiabetesFollowupDrugDao().insertInTx(list_diabetesFollowupDrug);
        sqlHelper.getHyperFollowupDrugDao().insertInTx(list_hyperFollowupDrug);

    }

    public void setData(HyperFollowup hyperFollowup, DiabetesFollowup diabetesFollowup, HyperFollowup oHyperFollowup, DiabetesFollowup oDiabetesFollowup) {
    List<HyperFollowupDrug> hyperFollowupDrugList =  sqlHelper.getHyperFollowupDrugDao().queryBuilder().where(HyperFollowupDrugDao.Properties.HyperFollowupId.eq(hyperFollowup.getHyperFollowupId())).list();
    List<DiabetesFollowupDrug> diabetesFollowupDrugList = sqlHelper.getDiabetesFollowupDrugDao().queryBuilder().where(DiabetesFollowupDrugDao.Properties.DiabetesFollowupId.eq(diabetesFollowup.getDiabetesFollowupId())).list();

    for (int i = 0;i<hyperFollowupDrugList.size();i++){
        addYY(hyperFollowupDrugList.get(i).getDrugId(),hyperFollowupDrugList.get(i).getDrugUsingFreq(),hyperFollowupDrugList.get(i).getDrugPerDose());
    }
        for (int j = 0;j<diabetesFollowupDrugList.size();j++){
            addYY(diabetesFollowupDrugList.get(j).getDrugId(),diabetesFollowupDrugList.get(j).getDrugUsingFreq(),diabetesFollowupDrugList.get(j).getDrugPerDose());
        }
    }

    private void showMed(final TextView tv) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View layout = inflater.inflate(R.layout.fu_diahy_yy_show,
                (ViewGroup) mFuView.findViewById(R.id.dialog));
        final AlertDialog.Builder ab = new AlertDialog.Builder(mContext)
                .setTitle("选取药品").setView(layout);
        final FuEditText m_input_med = (FuEditText) layout
                .findViewById(R.id.m_input_med);

        final ListView lv = (ListView) layout.findViewById(R.id.lv_med);
        final Dialog dialog = ab.show();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                tv.setText(list_sickMedicine.get(position).getName().toString());
                tv.setTag(list_sickMedicine.get(position));
                dialog.dismiss();
            }
        });
        ArrayAdapter<?> adapter = new ArrayAdapter(mContext,
                R.layout.fu_diahy_yy_ff, list_sickMedicine);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lv.setAdapter(adapter);
        m_input_med.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                String str = m_input_med.getText().toString().trim();
                if (str.length() > 0) {
                    str = "%" + str + "%";
                    QueryBuilder qb = sqlHelper.getSickMedicineDao().queryBuilder();
                    qb.whereOr(SickMedicineDao.Properties.Pym.like(str), SickMedicineDao.Properties.Wbm.like(str), SickMedicineDao.Properties.Name.like(str));
                    list_sickMedicine = qb.list();
                } else {
                    list_sickMedicine = sqlHelper.getSickMedicineDao().loadAll();
                }
                ArrayAdapter<?> adapter = new ArrayAdapter(mContext,
                        R.layout.fu_diahy_yy_ff, list_sickMedicine);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                lv.setAdapter(adapter);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

    }

    /**
     * 新增用药
     */
    private void addYY() {
        // TODO Auto-generated method stub
        final View vi = LayoutInflater.from(mContext).inflate(
                R.layout.fu_diahy_yy_item, null);
        vi.setId(index_id++);
        Spinner sp_medicineTimes = (Spinner) vi
                .findViewById(R.id.sp_medicineTimes);
        TextView tv_med = (TextView) vi.findViewById(R.id.tv_med);
        tv_med.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showMed((TextView) v);
            }
        });

        ImageView iv_delete = (ImageView) vi.findViewById(R.id.iv_delete);
        iv_delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ll_medicine.removeView(vi);
            }
        });

        ArrayAdapter<?> adapter = new ArrayAdapter(mContext,
                R.layout.fu_diahy_yy_ff, list_yf);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_medicineTimes.setAdapter(adapter);

        ll_medicine.addView(vi);
    }

    /**
     * 增加过去的
     * @param medicine_id
     * @param medicine_times
     * @param medicine_dosage
     */
    private void addYY(String medicine_id, String medicine_times,
                       String medicine_dosage) {
        final View vi = LayoutInflater.from(mContext).inflate(
                R.layout.fu_diahy_yy_item, null);
        vi.setId(index_id++);
        Spinner sp_medicineTimes = (Spinner) vi
                .findViewById(R.id.sp_medicineTimes);
        FuEditText et_medicineDosage = (FuEditText) vi
                .findViewById(R.id.et_medicineDosage);

        TextView tv_med = (TextView) vi.findViewById(R.id.tv_med);
        tv_med.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showMed((TextView) v);
            }
        });
        SickMedicine sickMedicine = sqlHelper.getSickMedicineDao().queryBuilder().where(SickMedicineDao.Properties.SickMedicineId.eq(medicine_id)).list().get(0);

        tv_med.setText(sickMedicine.getName());
        tv_med.setTag(sickMedicine);
        et_medicineDosage.setText(medicine_dosage);
        ImageView iv_delete = (ImageView) vi.findViewById(R.id.iv_delete);
        iv_delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ll_medicine.removeView(vi);
            }
        });
        // 药物名称

        ArrayAdapter<?> adapter = new ArrayAdapter(mContext,
                R.layout.fu_diahy_yy_ff, list_yf);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_medicineTimes.setAdapter(adapter);

        for (int i = 0; i < list_yf.size(); i++) {
            if (list_yf.get(i).getValue().equals(medicine_times))
                sp_medicineTimes.setSelection(i);
        }

        ll_medicine.addView(vi);
    }

}
