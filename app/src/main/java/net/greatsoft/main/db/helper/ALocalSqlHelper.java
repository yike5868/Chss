package net.greatsoft.main.db.helper;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.greatsoft.main.Constant;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.Dicts;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.SickMedicine;
import net.greatsoft.main.db.po.SpinnerItem;
import net.greatsoft.main.db.po.Term;
import net.greatsoft.main.db.po.UpdateState;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowup;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowupDrug;
import net.greatsoft.main.db.po.districts.Buildings;
import net.greatsoft.main.db.po.districts.Districts;
import net.greatsoft.main.db.po.districts.Room;
import net.greatsoft.main.db.po.districts.Subdistricts;
import net.greatsoft.main.db.po.exam.HealthExam;
import net.greatsoft.main.db.po.family.FamilyEconomic;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowup;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowupDrug;
import net.greatsoft.main.db.po.old.ElderCognition;
import net.greatsoft.main.db.po.person.Person;
import net.greatsoft.main.db.po.person.PersonCredential;
import net.greatsoft.main.db.po.person.PersonDisease;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.db.po.person.PersonPastHistory;
import net.greatsoft.main.db.po.smi.SmiFollowup;
import net.greatsoft.main.db.po.smi.SmiFollowupDrug;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhanglin on 16/8/22.
 */

public class ALocalSqlHelper {

    private Context context;
    DevOpenHelper devOpenHelper;
    DaoMaster daoMaster;

    DaoSession daoSession;
    /**
     * 根据地区获取相应的session 的索引
     */

    HashMap<String, Integer> indexMap;

    /**
     * SD卡数据库
     */
    List<DaoMaster> daoMasterList;
    List<DaoSession> daoSessionList;

    /**
     * 数据库版本
     */
    int dbVersion = 115;

    public ALocalSqlHelper(Context context) {

        this.context = context;

        devOpenHelper = new DevOpenHelper(context, Constant.DB_LOCAL, null);
        daoMaster = new DaoMaster(devOpenHelper.getReadableDb());

        daoMasterList = new ArrayList<>();
        daoSessionList = new ArrayList<>();

        getDb();
        getDaoSession();
    }

   
    /**
     * 根据personID 查询personinfo
     */

    public PersonInfo getPersonInfoByPersonInfoId(String personInfoId) {
        List<PersonInfo> personInfoList = getPersonInfoDao().queryBuilder().where(PersonInfoDao.Properties.PersonInfoId.eq(personInfoId)).list();
        if (personInfoList.size() > 0) {
            return personInfoList.get(0);
        }
        return null;
    }

    /**
     * 获取个人证件表
     */

    public List<PersonCredential> getPersonCredentialByPersonInfoId(String personInfoId) {
        return getPersonCredentialDao().queryBuilder().where(PersonCredentialDao.Properties.PersonInfoId.eq(personInfoId)).list();
    }

    /**
     * 获取个人既往史-手术、外伤、输血
     */

    public List<PersonPastHistory> getPersonPastHistoryByPersonInfoId(String personInfoId) {
        return getPersonPastHistoryDao().queryBuilder().where(PersonPastHistoryDao.Properties.PersonInfoId.eq(personInfoId)).list();
    }

    /**
     * 获取个人既往史疾病表
     */

    public List<PersonDisease> getPersonDiseaseByPersonInfoId(String personInfoId) {
        return getPersonDiseaseDao().queryBuilder().where(PersonDiseaseDao.Properties.PersonInfoId.eq(personInfoId)).list();
    }


    /**
     * 获取多选记录
     */

    public List<RecordChoice> getRecordChoiceByTableKey(String tableKey) {
        return getRecordChoiceDao().queryBuilder().where(RecordChoiceDao.Properties.TableKey.eq(tableKey)).list();
    }

    /**
     * 获取地区列表
     *
     * @return
     */
    public List<SpinnerItem> getDistricts() {
        List<SpinnerItem> spinnerItemList = new ArrayList<>();

        List<Districts> districtList = getDistrictsDao().queryBuilder().list();
        for (int i = 0; i < districtList.size(); i++) {
            SpinnerItem item = new SpinnerItem();
            item.setId(districtList.get(i).getDistrictId());
            item.setValue(districtList.get(i).getDistrictName());
            spinnerItemList.add(item);
        }
        return spinnerItemList;
    }

    public String getDistrictsName(String id) {

        List<Districts> districtList = getDistrictsDao().queryBuilder().where(DistrictsDao.Properties.DistrictId.eq(id)).list();
        if (districtList.size() > 0)
            return districtList.get(0).getDistrictName();
        return "";
    }


    /**
     * 获取字典版本
     */

    public Term getTermVersonByCode(String code){
        List<Term> termslist = getTermDao().queryBuilder().where(TermDao.Properties.Dict_code.eq(code)).list();
        if(termslist.size()>0){
            return termslist.get(0);
        }
        return null;
    }

    /**
     * 获取随访医生
     */
    public List<Emp> getAllEmpList() {
        List<Emp> empList = getEmpDao().queryBuilder().list();
        return empList;
    }

    /**
     * 获取地区列表
     *
     * @return
     */
    public List<Districts> getDistrictsAll() {

        List<Districts> districtList = getDistrictsDao().queryBuilder().list();

        return districtList;
    }

    /**
     * 获取小区列表
     *
     * @return
     */
    public List<SpinnerItem> getSubdistricts(String districtId) {
        List<SpinnerItem> spinnerItemList = new ArrayList<>();

        List<Subdistricts> subdistrictsList = getSubdistrictsDao().queryBuilder().where(SubdistrictsDao.Properties.DistrictId.eq(districtId)).list();
        for (int i = 0; i < subdistrictsList.size(); i++) {
            SpinnerItem item = new SpinnerItem();
            item.setId(subdistrictsList.get(i).getSubDistrictId());
            item.setValue(subdistrictsList.get(i).getSubDistrictName());
            spinnerItemList.add(item);
        }
        return spinnerItemList;
    }

    /**
     * 获取楼栋列表
     *
     * @return
     */
    public List<SpinnerItem> getBuildings(String subDistrictId) {
        List<SpinnerItem> spinnerItemList = new ArrayList<>();

        List<Buildings> subdistrictsList = getBuildingsDao().queryBuilder().where(BuildingsDao.Properties.SubDistrictId.eq(subDistrictId)).list();
        for (int i = 0; i < subdistrictsList.size(); i++) {
            SpinnerItem item = new SpinnerItem();
            item.setId(subdistrictsList.get(i).getBuildingId());
            item.setValue(subdistrictsList.get(i).getBuildingName());
            spinnerItemList.add(item);
        }
        return spinnerItemList;
    }

    /**
     * 获取单元列表
     *
     * @return
     */
    public List<SpinnerItem> getUnit(String buildingId) {
        List<SpinnerItem> spinnerItemList = new ArrayList<>();

        Cursor cursor = getRoomDao().getDatabase().rawQuery("select * from room where BUILDING_ID = '" + buildingId + "' group by UNIT_NO order by UNIT_NO", null);

        while (cursor.moveToNext()) {
            SpinnerItem item = new SpinnerItem();
            item.setId(cursor.getString(cursor.getColumnIndex("BUILDING_ID")));
            item.setValue(cursor.getString(cursor.getColumnIndex("UNIT_NO")));
            spinnerItemList.add(item);
        }
        return spinnerItemList;
    }

    /**
     * 获取房间列表
     *
     * @return
     */

    public List<SpinnerItem> getRoom(String buildingId, String unitNo) {

//        List<SpinnerItem> spinnerItemList = new ArrayList<>();
//
//        List<Room> roomList = getRoomDao().queryBuilder().where(RoomDao.Properties.BuildingId.eq(buildingId), RoomDao.Properties.UnitNo.eq(unitNo)).list();
//        for (int i = 0; i < roomList.size(); i++) {
//            SpinnerItem item = new SpinnerItem();
//            item.setId(roomList.get(i).getRoomNumberId());
//            item.setValue(roomList.get(i).getRoomNumberNo());
//            spinnerItemList.add(item);
//        }
        return null;
    }

    public List<Room> getRoomList(String buildingId, String unitNo) {

//        return getRoomDao().queryBuilder().where(RoomDao.Properties.BuildingId.eq(buildingId), RoomDao.Properties.UnitNo.eq(unitNo)).list();
        return null;
    }

    /**
     * 根据楼栋  单元获取家庭列表
     *
     * @return
     */
    public List<FamilyInfo> getFamilyInfoByUnit(String buildingId, String unit) {
        return getFamilyInfoDao().queryBuilder().where(FamilyInfoDao.Properties.Building.eq(buildingId), FamilyInfoDao.Properties.Unit.eq(unit)).list();

    }

    public FamilyInfo getFamilyInfoByFamilyInfoId(String familyInfoId) {
        return getFamilyInfoDao().queryBuilder().where(FamilyInfoDao.Properties.FamilyInfoId.eq(familyInfoId)).list().get(0);

    }

    /**
     * 获取糖尿病记录
     *
     * @return
     */

    public List<DiabetesFollowup> getDiabetesFollowupByPersonInfoId(String personInfoId) {
        return getDiabetesFollowupDao().queryBuilder().where(DiabetesFollowupDao.Properties.PersonInfoId.eq(personInfoId)).list();
    }

    /**
     * 获取高血压记录
     *
     * @return
     */

    public List<HyperFollowup> getHyperFollowupListByPersonInfoId(String personInfoId) {
        return getHyperFollowupDao().queryBuilder().where(HyperFollowupDao.Properties.PersonInfoId.eq(personInfoId)).list();
    }


    /**
     * 获取糖尿病记录
     *
     * @return
     */

    public List<DiabetesFollowup> getDiabetesFollowupListByPersonInfoId(String personInfoId) {
        return getDiabetesFollowupDao().queryBuilder().where(DiabetesFollowupDao.Properties.PersonInfoId.eq(personInfoId)).list();
    }

    /**
     * 获取体检记录
     *
     * @return
     */

    public List<HealthExam> getHealthExamListByPersonInfoId(String personInfoId) {
        return getHealthExamDao().queryBuilder().where(HealthExamDao.Properties.PersonInfoId.eq(personInfoId)).list();
    }

    /**
     * 插入体检记录
     */

    public long insertHealthExam(HealthExam healthExam) {

        return getHealthExamDao().insertOrReplace(healthExam);
    }
    /**
     * 获取字典
     */

    public String getChecksValueByCode(String code,String type ){
        List<Term> termList = getTermDao().queryBuilder().where(TermDao.Properties.Dict_code.eq(type),TermDao.Properties.Term_code.eq(code)).list();
        if(termList.size()>0){
            return termList.get(0).getTerm_name();
        }
        return "";
    }
    /**
     * 获取字典
     */

    public List<Checks> getChecksByTerm(String code){
       List<Term> termList = getTermDao().queryBuilder().where(TermDao.Properties.Dict_code.eq(code)).list();
        List<Checks> checksList = new ArrayList<>();
        for (int i = 0; i < termList.size(); i++) {
        Checks checks = new Checks();
            checks.setCode(termList.get(i).getTerm_code());
            checks.setType(termList.get(i).getDict_code());
            checks.setValue(termList.get(i).getTerm_name());
            checksList.add(checks);
        }
        return checksList;
    }

    /**
     * 获取字典
     */

    public String getCodeByTerm(String value){
        List<Term> termList = getTermDao().queryBuilder().where(TermDao.Properties.Term_name.eq(value)).list();
        if(termList.size()>0)
            return termList.get(0).getTerm_code();
        return "";
    }

    /**
     * 插入高血压记录
     */

    public long insertHyperFollowup(HyperFollowup hyperFollowup) {

        return getHyperFollowupDao().insertOrReplace(hyperFollowup);
    }

    /**
     * 插入糖尿病记录
     */

    public long insertDiabetesFollowup(DiabetesFollowup diabetes2Followup) {

        return getDiabetesFollowupDao().insertOrReplace(diabetes2Followup);
    }

    /**
     * 插入多选记录
     */
    public void insertRecordChoiceList(List<RecordChoice> recordChoiceList) {
        getRecordChoiceDao().insertInTx(recordChoiceList);
    }

    /**
     * @return
     */
    public FamilyEconomic getFamilyEconomicByFamilyInfoId(String familyInfoId) {
        List<FamilyEconomic> familyEconomicList = getFamilyEconomicDao().queryBuilder().where(FamilyEconomicDao.Properties.FamilyEconomicId.eq(familyInfoId)).list();
        if (familyEconomicList.size() > 0) {
            return familyEconomicList.get(0);
        } else
            return null;
    }

    /**
     * 获取药物
     */

//    public List<SickMedicine> getSickMedicineBySickCode(String sickCode) {
//        List<SickMedicine> sickMedicineList = new ArrayList<>();
//        List<SickChoiceMedicine> sickChoiceMedicineList = getSickChoiceMedicineDao().queryBuilder().where(SickChoiceMedicineDao.Properties.SickCode.eq(sickCode)).list();
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < sickChoiceMedicineList.size(); i++) {
//            list.add(sickChoiceMedicineList.get(i).getSickMedicineId());
//        }
//
//        if (list.size() > 0) {
//            sickMedicineList = getSickMedicineDao().queryBuilder().where(SickMedicineDao.Properties.Code.in(list)).list();
//        }
//        return sickMedicineList;
//    }


//    public List<SpinnerItem> getSpinnerItemBySickCode(String sickCode) {
//        List<SpinnerItem> list = new ArrayList<>();
//        SpinnerItem item = new SpinnerItem();
//        List<SickMedicine> sickMedicines = getSickMedicineBySickCode(sickCode);
//        for (int i = 0; i < sickMedicines.size(); i++) {
//            item.setId(sickMedicines.get(i).getSickMedicineId());
//            item.setType(sickCode);
//            item.setValue(sickMedicines.get(i).getName());
//            list.add(item);
//        }
//
//        return list;
//    }

    public Dicts getDicts(String type){
        List<Dicts> dictsList = getDictsDao().queryBuilder().where(DictsDao.Properties.Dict_code.eq(type)).list();
        if(dictsList.size()>0){
            return dictsList.get(0);
        }else{
            return null;
        }

    }

    public void deleteTerm(String code){
        getTermDao().queryBuilder().where(TermDao.Properties.Dict_code.eq(code)).buildDelete().executeDeleteWithoutDetachingEntities();
    }

    /**
     * 删除所有地区
     *
     * @return
     */

    public void deleteAllDistricts() {
        getDistrictsDao().queryBuilder().buildDelete().executeDeleteWithoutDetachingEntities();
    }
    /**
     * 删除所有小区
     *
     * @return
     */

    public void deleteAllSubDistricts() {
        getSubdistrictsDao().queryBuilder().buildDelete().executeDeleteWithoutDetachingEntities();
    }

    /**
     * 删除所有地区
     *
     * @return
     */

    public void insertAllDistricts(List<Districts> districts) {

        for (int i = 0; i < districts.size(); i++) {
            getDistrictsDao().insert(districts.get(i));
            if (districts.get(i).getSubDistrict() != null)
                getSubdistrictsDao().insertInTx(districts.get(i).getSubDistrict());
            if (districts.get(i).getChildren() != null && districts.get(i).getChildren().size() > 0) {
                insertAllDistricts(districts.get(i).getChildren());
            }
        }
    }


    public void insertSickMedicine(List<SickMedicine> sickMedicineList){
        getSickMedicineDao().insertInTx(sickMedicineList);
    }
    public List<SickMedicine> getSickMedicine(String type){
        return getSickMedicineDao().queryBuilder().where(SickMedicineDao.Properties.Type.eq(type)).list();
    }

    public void deleteAllSickMedicine(){
        getSickMedicineDao().deleteAll();
    }

    /**
     * 根据证件类型获取证件名称
     *
     * @return
     */

    public String getValueByCodeType(String code, String type) {
        List<Checks> checkses = getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq(type), ChecksDao.Properties.Code.eq(code)).list();
        if (checkses.size() > 0) {
            return checkses.get(0).getValue();
        }
        return "";
    }

    /**
     * 获取职业
     * @return
     */
    public List<Term> getProfession(){
        Term term = new Term("","","","","","");
        List<Term> list = getTermDao().queryBuilder().where(TermDao.Properties.Dict_code.eq("profession")).list();
        list.add(0,term);
        return list;
    }

    /**
     * 获取所有医生
     * @return
     */
    public List<Emp> getDoctors(){
        return getEmpDao().queryBuilder().list();
    }
    //===============================================================================================>>

    public PersonInfoDao getPersonInfoDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getPersonInfoDao();
    }

    /**
     * 人员Dao
     */
    public PersonDao getPersonDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getPersonDao();
    }

    public PersonDiseaseDao getPersonDiseaseDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getPersonDiseaseDao();
    }

    public HealthExamDao getHealthExamDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        HealthExamDao healthExamDao = daoSession.getHealthExamDao();
        return healthExamDao;
    }

    /**
     * 家庭证件列表
     */
    public FamilyCredentialDao getFamilyCredentialDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getFamilyCredentialDao();
    }


    /**
     * 家庭经济状况表
     *
     * @return
     */
    public FamilyEconomicDao getFamilyEconomicDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getFamilyEconomicDao();
    }

    public PersonCredentialDao getPersonCredentialDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getPersonCredentialDao();
    }

    /**
     * getFamilyEconomicDao
     * 家庭信息
     *
     * @return
     */
    public FamilyInfoDao getFamilyInfoDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getFamilyInfoDao();
    }

    /**
     * @return 个人病史
     */
    public PersonPastHistoryDao getPersonPastHistory() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getPersonPastHistoryDao();
    }

    /**
     * @return 个人健康体检住院用药情况实体
     */
    public HealthExamDrugDao getHealthExamDrugDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        HealthExamDrugDao healthExamDrugDao = daoSession.getHealthExamDrugDao();
        return healthExamDrugDao;
    }

    /**
     * @return 个人健康体检住院治疗情况实体
     */
    public HealthExamInhosDao getHealthExamInhosDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        HealthExamInhosDao healthExamInhosDao = daoSession.getHealthExamInhosDao();
        return healthExamInhosDao;
    }

    /**
     * @return 高血压随访从表
     */
    public HyperFollowupDrugDao getHyperFollowupDrugDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getHyperFollowupDrugDao();
    }

    /**
     * 糖尿病随访从表
     *
     * @return
     */

    public DiabetesFollowupDrugDao getDiabetesFollowupDrugDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getDiabetesFollowupDrugDao();
    }

    /**
     * 重性精神病随访从表
     *
     * @return
     */

    public SmiFollowupDrugDao getSmiFollowupDrugDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getSmiFollowupDrugDao();
    }


    /**
     * @return 高血压随访
     */
    public HyperFollowupDao getHyperFollowupDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getHyperFollowupDao();
    }

    /**
     * @return 糖尿病随访
     */
    public DiabetesFollowupDao getDiabetesFollowupDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getDiabetesFollowupDao();
    }

    /**
     * @return 重性精神病随访
     */
    public SmiFollowupDao getSmiFollowupDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getSmiFollowupDao();
    }

    /**
     * @return 老年人认知功能随访
     */
    public ElderCognitionDao getElderCognitionDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getElderCognitionDao();
    }

    /**
     * @return 个人健康体检非免疫规划预防接种史实体
     */
    public HealthExamNoplanVaccDao getHealthExamNoplanVaccDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        HealthExamNoplanVaccDao healthExamNoplanVaccDao = daoSession.getHealthExamNoplanVaccDao();
        return healthExamNoplanVaccDao;
    }

    public ColorsDao getColorsDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        ColorsDao colorsDao = daoSession.getColorsDao();
        return colorsDao;
    }

    /**
     * @return 单选多选
     */
    public ChecksDao getChecksDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        ChecksDao checksDao = daoSession.getChecksDao();
        return checksDao;
    }

    /**
     * @return 重症患者常用药品
     */
    public SickChoiceMedicineDao getSickChoiceMedicineDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getSickChoiceMedicineDao();
    }

    public SickMedicineDao getSickMedicineDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getSickMedicineDao();
    }

    /**
     * 保存的多选
     *
     * @return
     */
    public RecordChoiceDao getRecordChoiceDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        RecordChoiceDao recordChoiceDao = daoSession.getRecordChoiceDao();
        return recordChoiceDao;
    }

    /**
     * 个人
     */
    public PersonPastHistoryDao getPersonPastHistoryDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession.getPersonPastHistoryDao();
    }

    /**
     * 地区
     */
    public DistrictsDao getDistrictsDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        DistrictsDao districtsDao = daoSession.getDistrictsDao();
        return districtsDao;
    }


    /**
     * 小区
     */
    public SubdistrictsDao getSubdistrictsDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        SubdistrictsDao subdistrictsDao = daoSession.getSubdistrictsDao();
        return subdistrictsDao;
    }

    /**
     * 楼栋
     */
    public BuildingsDao getBuildingsDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        BuildingsDao buildingsDao = daoSession.getBuildingsDao();
        return buildingsDao;
    }

    /**
     * 房间
     */
    public RoomDao getRoomDao() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        RoomDao roomDao = daoSession.getRoomDao();
        return roomDao;
    }

    /**
     * session
     *
     * @return
     */

    public SessionRspDao getSessionRspDap() {
        if (daoSession == null)
            daoSession = daoMaster.newSession();
        SessionRspDao sessionRspDao = daoSession.getSessionRspDao();
        return sessionRspDao;
    }


    public EmpDao getEmpDao() {
        if (daoSession == null) {
            daoSession = daoMaster.newSession();
        }
        EmpDao empDao = daoSession.getEmpDao();
        return empDao;
    }

    public DictsDao getDictsDao(){
        if (daoSession == null) {
            daoSession = daoMaster.newSession();
        }
        DictsDao dictsDao = daoSession.getDictsDao();
        return dictsDao;
    }

    public TermDao getTermDao(){
        if (daoSession == null) {
            daoSession = daoMaster.newSession();
        }
        TermDao termDao = daoSession.getTermDao();
        return termDao;
    }

    public void getDaoSession() {
        daoSessionList.clear();
        for (int i = 0; i < daoMasterList.size(); i++) {
            daoSessionList.add(daoMasterList.get(i).newSession());
        }
    }

    public List<Checks> getChecksByType(String type) {
        return getChecksDao().queryBuilder().where(ChecksDao.Properties.Type.eq(type)).orderAsc(ChecksDao.Properties.Code).list();
    }

    /**
     * 写入单选多选按钮
     */
    public void write() {
        List list = getChecksByType("CULTUREDEGREE");
        ChecksDao checksDao = getChecksDao();
        List list1 = checksDao.queryBuilder().list();
        if (list1.size() < 1 || list.size() < 10) {
            updateDb();
        }
        File file = new File(android.os.Environment.getExternalStorageDirectory()+"/wltlib");
        if(!file.exists()){
            CopyAssetsDir("wltlib",android.os.Environment.getExternalStorageDirectory().getAbsolutePath());
        }
    }


    public void updateDb() {
        InputStream inputStream;
        getChecksDao().queryBuilder().buildDelete().executeDeleteWithoutDetachingEntities();
        /**
         * 因为测试  过去的修改  在第二版之后需要清空
         */
        try {

            inputStream = context.getResources().getAssets().open("checks.db");

            File file = new File(Constant.DB_DIR);

            if (!file.exists()) {

                file.mkdirs();

            }

            File dab = new File(Constant.DB_CHECKS);
            if (dab.exists()) {
                dab.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(Constant.DB_CHECKS);

            byte[] buffer = new byte[512];

            int count = 0;

            while ((count = inputStream.read(buffer)) > 0) {

                fileOutputStream.write(buffer, 0, count);

            }

            fileOutputStream.flush();

            fileOutputStream.close();

            inputStream.close();

            ChecksDao checksDao = getChecksDao();

            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(Constant.DB_CHECKS, null);
            Cursor c = db.rawQuery("select *from Checks", null);
//            DaoMaster dm = new DaoMaster(context);

            /**
             * 单选多选
             */

            while (c.moveToNext()) {
                Checks check = new Checks();
                check.setCode(c.getString(c.getColumnIndex("code")));
                check.setIsDefault(c.getString(c.getColumnIndex("isDefault")));
                check.setIsOther(c.getString(c.getColumnIndex("isOther")));
                check.setType(c.getString(c.getColumnIndex("type")));
                check.setValue(c.getString(c.getColumnIndex("value")));
                check.setSerialNumber(c.getInt(c.getColumnIndex("serialNumber")));
                checksDao.insert(check);
            }

            if (db.isOpen()) {
                c.close();
                db.close();
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
    private Boolean CopyAssetsDir(String src,String des) {
        //复制安卓Assets下的“非空目录”到des文件夹，注意是否对des有写权限
        Boolean isSuccess = true;
        String[] files;
        try
        {
            files = context.getResources().getAssets().list(src);
        }
        catch (IOException e1)
        {
            return false;
        }

        if(files.length==0){
            isSuccess = CopyAssetsFile(src,des);//对于文件直接复制
            if(!isSuccess)
                return isSuccess;
        }
        else{
            File srcfile = new File(des+"/"+src);
            if(!srcfile.exists()){
                if(srcfile.mkdirs()){//对于目录自行创建
                    for(int i=0;i<files.length;i++){//新浪博客的限制，这里的小于号请自行替换为英文的
                        isSuccess = CopyAssetsDir(src + "/"+files[i], des);//递归调用
                        if(!isSuccess)
                            return isSuccess;
                    }
                }
                else{
                    return false;
                }
            }

        }
        return isSuccess;
    }

    private Boolean CopyAssetsFile(String filename, String des) {
        Boolean isSuccess = true;
        //复制安卓apk的assets目录下任意路径的单个文件到des文件夹，注意是否对des有写权限
        AssetManager assetManager = context.getAssets();

        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(filename);
            String newFileName = des + "/" + filename;
            out = new FileOutputStream(newFileName);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }

        return isSuccess;

    }

    private boolean isExist() {

        File file = new File(Constant.DB_CHECKS);

        if (file.exists()) {

            return true;

        } else {

            return false;

        }

    }

    /**
     * 获取sd卡中的daomaster
     */
    public void getDb() {
        indexMap = new HashMap<>();
        daoMasterList.clear();
        File localdri = new File(Constant.LOCAL_DB);
        File[] localdbs = localdri.listFiles();
        if (localdbs == null) {
            return;
        }
        for (int i = 0; i < localdbs.length; i++) {
            if (!localdbs[i].getName().endsWith(".db")) {
                continue;
            }
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(localdbs[i], null);
            db.setVersion(dbVersion);
            daoMasterList.add(new DaoMaster(db));
            String[] name = localdbs[i].getName().split("_");
            indexMap.put(name[0], daoMasterList.size() - 1);
        }
    }


    /**
     * 离线内容
     */


    /**
     * 根据 地区 familyinfoid 查询familyinfo
     *
     * @param residential
     * @param familyInfoId
     * @return
     */
    public FamilyInfo getFamilyInfoByFamilyInfoId(String residential, String familyInfoId) {
        DaoSession session = getSession(residential);
        FamilyInfoDao familyInfoDao = session.getFamilyInfoDao();
        List<FamilyInfo> familyInfoList = familyInfoDao.queryBuilder().where(FamilyInfoDao.Properties.FamilyInfoId.eq(familyInfoId)).list();
        if (familyInfoList.size() > 0) {
            return familyInfoList.get(0);
        } else {
            familyInfoDao = daoSession.getFamilyInfoDao();
            familyInfoList = familyInfoDao.queryBuilder().where(FamilyInfoDao.Properties.FamilyInfoId.eq(familyInfoId)).list();
            if (familyInfoList.size() > 0) {
                return familyInfoList.get(0);
            }
        }
        return null;
    }

    /**
     * 插入本地家庭
     *
     * @param familyInfo
     */
    public void insertLocalFamilyInfo(FamilyInfo familyInfo) {

        familyInfo.getFamilyEconomic();
        familyInfo.getFamilyCredential();
        familyInfo.getRecordChoice();

        //编辑的时候先删除
        getSession(familyInfo.getResidential()).getFamilyInfoDao().queryBuilder().where(FamilyInfoDao.Properties.FamilyInfoId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        getSession(familyInfo.getResidential()).getFamilyEconomicDao().queryBuilder().where(FamilyEconomicDao.Properties.FamilyInfoId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        getSession(familyInfo.getResidential()).getFamilyCredentialDao().queryBuilder().where(FamilyCredentialDao.Properties.FamilyInfoId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        getSession(familyInfo.getResidential()).getRecordChoiceDao().queryBuilder().where(RecordChoiceDao.Properties.TableKey.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
//        getSession(familyInfo.getResidential()).getFamilyDao().queryBuilder().where(FamilyDao.Properties.FamilyId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();


        //删除本地
        daoSession.getFamilyInfoDao().queryBuilder().where(FamilyInfoDao.Properties.FamilyInfoId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        daoSession.getFamilyEconomicDao().queryBuilder().where(FamilyEconomicDao.Properties.FamilyInfoId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        daoSession.getFamilyCredentialDao().queryBuilder().where(FamilyCredentialDao.Properties.FamilyInfoId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        daoSession.getRecordChoiceDao().queryBuilder().where(RecordChoiceDao.Properties.TableKey.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
//        daoSession.getFamilyDao().queryBuilder().where(FamilyDao.Properties.FamilyId.eq(familyInfo.getFamilyInfoId())).buildDelete().executeDeleteWithoutDetachingEntities();
        if (familyInfo != null)
            daoSession.getFamilyInfoDao().insert(familyInfo);
        if (familyInfo.getFamilyEconomic() != null)
            daoSession.getFamilyEconomicDao().insert(familyInfo.getFamilyEconomic());
        if (familyInfo.getFamilyCredential() != null)
            daoSession.getFamilyCredentialDao().insertInTx(familyInfo.getFamilyCredential());
        if (familyInfo.getRecordChoice() != null)
            daoSession.getRecordChoiceDao().insertInTx(familyInfo.getRecordChoice());
//        daoSession.getFamilyDao().insert(familyInfo.getFamily());

        //插入updatestate
        insertUpdateState(familyInfo.getFamilyInfoId(), Constant.SERVICE_ITEM_1010, "", familyInfo.getHouseholder(), familyInfo.getCreateTime());

    }


    /**
     * 插入上传信息
     */

    public void insertUpdateState(String tableKey, String tableType, String tableReson, String name, Date time) {

        UpdateState state = new UpdateState(tableKey, tableType, 0, tableReson, name, time == null ? "" : time.toString());
        deleteUpdateStateByKey(tableKey);
        daoSession.getUpdateStateDao().insert(state);
    }

    /**
     * 删除上传信息
     */

    public void deleteUpdateStateByKey(String tableKey) {
        daoSession.getUpdateStateDao().queryBuilder().where(UpdateStateDao.Properties.TableKey.eq(tableKey)).buildDelete().executeDeleteWithoutDetachingEntities();
    }

    /**
     * 根据地区获取相应的session
     */
    public DaoSession getSession(String residential) {
        if (indexMap == null)
            getDb();
        if (indexMap.get(residential) != null) {
            Integer index = indexMap.get(residential);
            return daoSessionList.get(index);
        }
        return daoSession;
    }

}
