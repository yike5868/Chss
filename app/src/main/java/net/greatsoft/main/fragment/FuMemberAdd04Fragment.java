package net.greatsoft.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.control.FragmentParent;
import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.control.FuResponse;
import net.greatsoft.main.control.fragment.FragmentSave;
import net.greatsoft.main.control.fragment.FuUiFrameManager;
import net.greatsoft.main.db.helper.PersonCredentialDao;
import net.greatsoft.main.db.helper.PersonDiseaseDao;
import net.greatsoft.main.db.helper.PersonInfoDao;
import net.greatsoft.main.db.helper.PersonPastHistoryDao;
import net.greatsoft.main.db.helper.RecordChoiceDao;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.uiframe.FuMemberAdd04View;

import java.util.List;

/**
 * User: sgd(952519440@qq.com)
 * Date: 2016/11/21
 * Time: 09:08
 * progject: Chss_FollowUp
 * Describe：入户随访-新增家庭成员-生活环境
 */

public class FuMemberAdd04Fragment extends FragmentParent implements FragmentSave {


//    List<PersonCredential> list_personCredential  = new ArrayList<>();
    String personInfoId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FuUiFrameManager lFuUiFrameManager = ((FuApp) getActivity()
                .getApplication()).getFuUiFrameManager();

        mModel = lFuUiFrameManager.createFuModel(
                FuUiFrameManager.FU_MEMBERADD_04, getActivity(),
                new OnEventClick());

        if(personInfoId != null){
            List<PersonInfo> list = getSqlHelper().getPersonInfoDao().queryBuilder().where(PersonInfoDao.Properties.PersonInfoId.eq(personInfoId)).list();
            personInfo = list.get(0);
        }
        setData();

        return mModel.getFuView();
    }


    class OnEventClick implements FuEventCallBack {

        @Override
        public void EventClick(int event, Object object) {

        }
    }

    @Override
    protected void loadDataChild(int taskId, FuResponse rspObj) {

    }

    @Override
    protected void netErrorChild(int taskId, String msg) {

    }

    @Override
    protected void cancelChild(int taskId) {

    }

    @Override
    public boolean saveData() {
        ((FuMemberAdd04View) mModel).saveData(personInfo);

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

        return false;
    }

    public boolean setData() {
        ((FuMemberAdd04View) mModel).setData(personInfo);

        return true;
    }
}

