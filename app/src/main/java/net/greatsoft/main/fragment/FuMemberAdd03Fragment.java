package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.activity.FuContentActivity;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FragmentSave;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.uiframe.FuMemberAdd03View;

import java.util.ArrayList;
import java.util.UUID;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/11/18
 * Time: 16:48
 * progject: Chss_FollowUp
 * Describe：入户随访-新增家庭成员-医疗费用支付
 */

public class FuMemberAdd03Fragment extends FragmentParent implements FragmentSave {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_MEMBERADD_03, getActivity(),
                new OnEventClick());

        setData();

        return mModel.getFuView();
    }

    public void intentData(Bundle bundle){
        if(bundle==null){
            String id = UUID.randomUUID().toString();
            personInfo = new PersonInfo();
            personInfo.setPersonInfoId(id);
        }else{
            personInfoId  = bundle.getString("PersonInfoId");

        }


    }

    public static final int EVENT_SAVE_PERSON = 1;

    @Override
    public boolean saveData() {
        ((FuMemberAdd03View) mModel).saveData(personInfo);
        return false;
    }

    class OnEventClick implements FuEventCallBack{

        @Override
        public void EventClick(int event, Object object) {
            switch (event){
                case EVENT_SAVE_PERSON:
//                    saveData();
                    ((FuContentActivity) getActivity()).goToPrePage();
                    break;
            }
        }
    }

    public boolean setData(){
//        ((FuMemberAdd03View)mModel).setData(personInfo);
        ((FuMemberAdd03View) mModel).setData(personInfo);

        return true;
    }

//    public void saveData(){
//        ((FuMemberAdd03View)mModel).saveData(personInfo,list_recordChoice,list_personDisease,list_personPastHistory,list_personCredential);
//
//        sqlHelper.getPersonInfoDao().queryBuilder().where(PersonInfoDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
//        sqlHelper.getPersonPastHistory().queryBuilder().where(PersonPastHistoryDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
//        sqlHelper.getPersonDiseaseDao().queryBuilder().where(PersonDiseaseDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
//        sqlHelper.getRecordChoiceDao().queryBuilder().where(RecordChoiceDao.Properties.TableKey.eq(personInfo.getPersonInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
//        sqlHelper.getPersonCredentialDao().queryBuilder().where(PersonCredentialDao.Properties.PersonInfoId.eq(personInfo.getPersonInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
//
//        sqlHelper.getPersonInfoDao().insert(personInfo);
//        sqlHelper.getPersonDiseaseDao().insertInTx(list_personDisease);
//        sqlHelper.getRecordChoiceDao().insertInTx(list_recordChoice);
//        sqlHelper.getPersonPastHistory().insertInTx(list_personPastHistory);
//        sqlHelper.getPersonCredentialDao().insertInTx(list_personCredential);
//    }

    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {

    }

    @Override
    protected void netErrorChild(int taskId, String msg) {

    }

    @Override
    protected void cancelChild(int taskId) {

    }
}
