package net.greatsoft.main.db.helper;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import net.greatsoft.main.db.po.AndroidFileRecord;
import net.greatsoft.main.db.po.cerebralApoplexy.CaInfoDrugs;
import net.greatsoft.main.db.po.cerebralApoplexy.CerebralApoplexyFollowup;
import net.greatsoft.main.db.po.cerebralApoplexy.CerebralApoplexyInfo;
import net.greatsoft.main.db.po.Checks;
import net.greatsoft.main.db.po.child.ChildDeath;
import net.greatsoft.main.db.po.child.ChildDiseaseScreen;
import net.greatsoft.main.db.po.child.ChildDiseaseScreenDiag;
import net.greatsoft.main.db.po.child.ChildDiseaseScreenResult;
import net.greatsoft.main.db.po.child.ChildHealthExam;
import net.greatsoft.main.db.po.child.ChildHearScreen;
import net.greatsoft.main.db.po.child.ChildHomeVisit;
import net.greatsoft.main.db.po.child.ChildInfo;
import net.greatsoft.main.db.po.child.ChildLedger;
import net.greatsoft.main.db.po.child.ChildPerinatalDeath;
import net.greatsoft.main.db.po.child.ChildTcmLedger;
import net.greatsoft.main.db.po.child.ChildWeakFollowup;
import net.greatsoft.main.db.po.child.ChildWeakInfo;
import net.greatsoft.main.db.po.Colors;
import net.greatsoft.main.db.po.corconaryHeart.ChdInfoDrugs;
import net.greatsoft.main.db.po.corconaryHeart.CoronaryHeartDiseaseFollowup;
import net.greatsoft.main.db.po.corconaryHeart.CoronaryHeartDiseaseInfo;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowup;
import net.greatsoft.main.db.po.diabetes.DiabetesFollowupDrug;
import net.greatsoft.main.db.po.diabetes.DiabetesInfo;
import net.greatsoft.main.db.po.diabetes.DiabetesInfoComp;
import net.greatsoft.main.db.po.diabetes.DiabetesInfoDrug;
import net.greatsoft.main.db.po.diabetes.DiabetesLedger;
import net.greatsoft.main.db.po.Dicts;
import net.greatsoft.main.db.po.disability.DisabilityHearing;
import net.greatsoft.main.db.po.disability.DisabilityIntelligence;
import net.greatsoft.main.db.po.disability.DisabilityLimb;
import net.greatsoft.main.db.po.disability.DisabilityVisual;
import net.greatsoft.main.db.po.districts.Buildings;
import net.greatsoft.main.db.po.districts.Districts;
import net.greatsoft.main.db.po.districts.Room;
import net.greatsoft.main.db.po.districts.Subdistricts;
import net.greatsoft.main.db.po.Doctor;
import net.greatsoft.main.db.po.Emp;
import net.greatsoft.main.db.po.exam.HealthExam;
import net.greatsoft.main.db.po.exam.HealthExamDrug;
import net.greatsoft.main.db.po.exam.HealthExamInhos;
import net.greatsoft.main.db.po.exam.HealthExamNoplanVacc;
import net.greatsoft.main.db.po.family.AgencyFamily;
import net.greatsoft.main.db.po.family.Family;
import net.greatsoft.main.db.po.family.FamilyCredential;
import net.greatsoft.main.db.po.family.FamilyDoctor;
import net.greatsoft.main.db.po.family.FamilyEconomic;
import net.greatsoft.main.db.po.family.FamilyInfo;
import net.greatsoft.main.db.po.family.FamilyMember;
import net.greatsoft.main.db.po.family.FamilyMovedLog;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowup;
import net.greatsoft.main.db.po.hyperinfo.HyperFollowupDrug;
import net.greatsoft.main.db.po.hyperinfo.HyperInfo;
import net.greatsoft.main.db.po.hyperinfo.HyperInfoDrug;
import net.greatsoft.main.db.po.hyperinfo.HyperLedger;
import net.greatsoft.main.db.po.maternal.MaternalChildbirth;
import net.greatsoft.main.db.po.maternal.MaternalFirstFollowup;
import net.greatsoft.main.db.po.maternal.MaternalFollowup;
import net.greatsoft.main.db.po.maternal.MaternalNewbornSituation;
import net.greatsoft.main.db.po.maternal.MaternalPostpartumFollowup;
import net.greatsoft.main.db.po.maternal.MaternalRegister;
import net.greatsoft.main.db.po.MaternalInfo;
import net.greatsoft.main.db.po.old.ElderCognition;
import net.greatsoft.main.db.po.old.ElderDepressed;
import net.greatsoft.main.db.po.old.ElderExamLedger;
import net.greatsoft.main.db.po.old.ElderInfo;
import net.greatsoft.main.db.po.old.ElderSelfcareAbility;
import net.greatsoft.main.db.po.old.ElderTcmHealth;
import net.greatsoft.main.db.po.old.ElderTcmLedger;
import net.greatsoft.main.db.po.person.AgencyPerson;
import net.greatsoft.main.db.po.person.MemberMovedLog;
import net.greatsoft.main.db.po.person.Person;
import net.greatsoft.main.db.po.person.PersonAddress;
import net.greatsoft.main.db.po.person.PersonCredential;
import net.greatsoft.main.db.po.person.PersonDeath;
import net.greatsoft.main.db.po.person.PersonDisease;
import net.greatsoft.main.db.po.person.PersonInfo;
import net.greatsoft.main.db.po.person.PersonPastHistory;
import net.greatsoft.main.db.po.person.PersonSerialNo;
import net.greatsoft.main.db.po.person.PersonServiceCatalog;
import net.greatsoft.main.db.po.RecordChoice;
import net.greatsoft.main.db.po.SickChoiceMedicine;
import net.greatsoft.main.db.po.SickMedicine;
import net.greatsoft.main.db.po.smi.SmiFollowup;
import net.greatsoft.main.db.po.smi.SmiFollowupDrug;
import net.greatsoft.main.db.po.smi.SmiInfo;
import net.greatsoft.main.db.po.Term;
import net.greatsoft.main.db.po.tuberculosis.TuberculosisFirstFollowup;
import net.greatsoft.main.db.po.tuberculosis.TuberculosisFollowup;
import net.greatsoft.main.db.po.tuberculosis.TuberculosisInfo;
import net.greatsoft.main.db.po.tuberculosis.TuberculosisReferral;
import net.greatsoft.main.db.po.UpdateState;
import net.greatsoft.main.db.po.vaccine.CdcVaccreport;
import net.greatsoft.main.db.po.vaccine.CdcVaccreportAdverse;
import net.greatsoft.main.db.po.vaccine.CdcVaccreportVaccinate;
import net.greatsoft.main.db.po.vaccine.OrgChoiceVaccine;
import net.greatsoft.main.db.po.vaccine.Vaccine;
import net.greatsoft.main.db.po.vaccine.VaccineBatchno;
import net.greatsoft.main.db.po.vaccine.VaccineInjectTimes;
import net.greatsoft.main.db.po.vaccine.VaccineManufacturer;
import net.greatsoft.main.db.po.VisitDetail;
import net.greatsoft.main.db.po.VisitMedicine;
import net.greatsoft.main.rsp.SessionRsp;

import net.greatsoft.main.db.helper.AndroidFileRecordDao;
import net.greatsoft.main.db.helper.CaInfoDrugsDao;
import net.greatsoft.main.db.helper.CerebralApoplexyFollowupDao;
import net.greatsoft.main.db.helper.CerebralApoplexyInfoDao;
import net.greatsoft.main.db.helper.ChecksDao;
import net.greatsoft.main.db.helper.ChildDeathDao;
import net.greatsoft.main.db.helper.ChildDiseaseScreenDao;
import net.greatsoft.main.db.helper.ChildDiseaseScreenDiagDao;
import net.greatsoft.main.db.helper.ChildDiseaseScreenResultDao;
import net.greatsoft.main.db.helper.ChildHealthExamDao;
import net.greatsoft.main.db.helper.ChildHearScreenDao;
import net.greatsoft.main.db.helper.ChildHomeVisitDao;
import net.greatsoft.main.db.helper.ChildInfoDao;
import net.greatsoft.main.db.helper.ChildLedgerDao;
import net.greatsoft.main.db.helper.ChildPerinatalDeathDao;
import net.greatsoft.main.db.helper.ChildTcmLedgerDao;
import net.greatsoft.main.db.helper.ChildWeakFollowupDao;
import net.greatsoft.main.db.helper.ChildWeakInfoDao;
import net.greatsoft.main.db.helper.ColorsDao;
import net.greatsoft.main.db.helper.ChdInfoDrugsDao;
import net.greatsoft.main.db.helper.CoronaryHeartDiseaseFollowupDao;
import net.greatsoft.main.db.helper.CoronaryHeartDiseaseInfoDao;
import net.greatsoft.main.db.helper.DiabetesFollowupDao;
import net.greatsoft.main.db.helper.DiabetesFollowupDrugDao;
import net.greatsoft.main.db.helper.DiabetesInfoDao;
import net.greatsoft.main.db.helper.DiabetesInfoCompDao;
import net.greatsoft.main.db.helper.DiabetesInfoDrugDao;
import net.greatsoft.main.db.helper.DiabetesLedgerDao;
import net.greatsoft.main.db.helper.DictsDao;
import net.greatsoft.main.db.helper.DisabilityHearingDao;
import net.greatsoft.main.db.helper.DisabilityIntelligenceDao;
import net.greatsoft.main.db.helper.DisabilityLimbDao;
import net.greatsoft.main.db.helper.DisabilityVisualDao;
import net.greatsoft.main.db.helper.BuildingsDao;
import net.greatsoft.main.db.helper.DistrictsDao;
import net.greatsoft.main.db.helper.RoomDao;
import net.greatsoft.main.db.helper.SubdistrictsDao;
import net.greatsoft.main.db.helper.DoctorDao;
import net.greatsoft.main.db.helper.EmpDao;
import net.greatsoft.main.db.helper.HealthExamDao;
import net.greatsoft.main.db.helper.HealthExamDrugDao;
import net.greatsoft.main.db.helper.HealthExamInhosDao;
import net.greatsoft.main.db.helper.HealthExamNoplanVaccDao;
import net.greatsoft.main.db.helper.AgencyFamilyDao;
import net.greatsoft.main.db.helper.FamilyDao;
import net.greatsoft.main.db.helper.FamilyCredentialDao;
import net.greatsoft.main.db.helper.FamilyDoctorDao;
import net.greatsoft.main.db.helper.FamilyEconomicDao;
import net.greatsoft.main.db.helper.FamilyInfoDao;
import net.greatsoft.main.db.helper.FamilyMemberDao;
import net.greatsoft.main.db.helper.FamilyMovedLogDao;
import net.greatsoft.main.db.helper.HyperFollowupDao;
import net.greatsoft.main.db.helper.HyperFollowupDrugDao;
import net.greatsoft.main.db.helper.HyperInfoDao;
import net.greatsoft.main.db.helper.HyperInfoDrugDao;
import net.greatsoft.main.db.helper.HyperLedgerDao;
import net.greatsoft.main.db.helper.MaternalChildbirthDao;
import net.greatsoft.main.db.helper.MaternalFirstFollowupDao;
import net.greatsoft.main.db.helper.MaternalFollowupDao;
import net.greatsoft.main.db.helper.MaternalNewbornSituationDao;
import net.greatsoft.main.db.helper.MaternalPostpartumFollowupDao;
import net.greatsoft.main.db.helper.MaternalRegisterDao;
import net.greatsoft.main.db.helper.MaternalInfoDao;
import net.greatsoft.main.db.helper.ElderCognitionDao;
import net.greatsoft.main.db.helper.ElderDepressedDao;
import net.greatsoft.main.db.helper.ElderExamLedgerDao;
import net.greatsoft.main.db.helper.ElderInfoDao;
import net.greatsoft.main.db.helper.ElderSelfcareAbilityDao;
import net.greatsoft.main.db.helper.ElderTcmHealthDao;
import net.greatsoft.main.db.helper.ElderTcmLedgerDao;
import net.greatsoft.main.db.helper.AgencyPersonDao;
import net.greatsoft.main.db.helper.MemberMovedLogDao;
import net.greatsoft.main.db.helper.PersonDao;
import net.greatsoft.main.db.helper.PersonAddressDao;
import net.greatsoft.main.db.helper.PersonCredentialDao;
import net.greatsoft.main.db.helper.PersonDeathDao;
import net.greatsoft.main.db.helper.PersonDiseaseDao;
import net.greatsoft.main.db.helper.PersonInfoDao;
import net.greatsoft.main.db.helper.PersonPastHistoryDao;
import net.greatsoft.main.db.helper.PersonSerialNoDao;
import net.greatsoft.main.db.helper.PersonServiceCatalogDao;
import net.greatsoft.main.db.helper.RecordChoiceDao;
import net.greatsoft.main.db.helper.SickChoiceMedicineDao;
import net.greatsoft.main.db.helper.SickMedicineDao;
import net.greatsoft.main.db.helper.SmiFollowupDao;
import net.greatsoft.main.db.helper.SmiFollowupDrugDao;
import net.greatsoft.main.db.helper.SmiInfoDao;
import net.greatsoft.main.db.helper.TermDao;
import net.greatsoft.main.db.helper.TuberculosisFirstFollowupDao;
import net.greatsoft.main.db.helper.TuberculosisFollowupDao;
import net.greatsoft.main.db.helper.TuberculosisInfoDao;
import net.greatsoft.main.db.helper.TuberculosisReferralDao;
import net.greatsoft.main.db.helper.UpdateStateDao;
import net.greatsoft.main.db.helper.CdcVaccreportDao;
import net.greatsoft.main.db.helper.CdcVaccreportAdverseDao;
import net.greatsoft.main.db.helper.CdcVaccreportVaccinateDao;
import net.greatsoft.main.db.helper.OrgChoiceVaccineDao;
import net.greatsoft.main.db.helper.VaccineDao;
import net.greatsoft.main.db.helper.VaccineBatchnoDao;
import net.greatsoft.main.db.helper.VaccineInjectTimesDao;
import net.greatsoft.main.db.helper.VaccineManufacturerDao;
import net.greatsoft.main.db.helper.VisitDetailDao;
import net.greatsoft.main.db.helper.VisitMedicineDao;
import net.greatsoft.main.db.helper.SessionRspDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig androidFileRecordDaoConfig;
    private final DaoConfig caInfoDrugsDaoConfig;
    private final DaoConfig cerebralApoplexyFollowupDaoConfig;
    private final DaoConfig cerebralApoplexyInfoDaoConfig;
    private final DaoConfig checksDaoConfig;
    private final DaoConfig childDeathDaoConfig;
    private final DaoConfig childDiseaseScreenDaoConfig;
    private final DaoConfig childDiseaseScreenDiagDaoConfig;
    private final DaoConfig childDiseaseScreenResultDaoConfig;
    private final DaoConfig childHealthExamDaoConfig;
    private final DaoConfig childHearScreenDaoConfig;
    private final DaoConfig childHomeVisitDaoConfig;
    private final DaoConfig childInfoDaoConfig;
    private final DaoConfig childLedgerDaoConfig;
    private final DaoConfig childPerinatalDeathDaoConfig;
    private final DaoConfig childTcmLedgerDaoConfig;
    private final DaoConfig childWeakFollowupDaoConfig;
    private final DaoConfig childWeakInfoDaoConfig;
    private final DaoConfig colorsDaoConfig;
    private final DaoConfig chdInfoDrugsDaoConfig;
    private final DaoConfig coronaryHeartDiseaseFollowupDaoConfig;
    private final DaoConfig coronaryHeartDiseaseInfoDaoConfig;
    private final DaoConfig diabetesFollowupDaoConfig;
    private final DaoConfig diabetesFollowupDrugDaoConfig;
    private final DaoConfig diabetesInfoDaoConfig;
    private final DaoConfig diabetesInfoCompDaoConfig;
    private final DaoConfig diabetesInfoDrugDaoConfig;
    private final DaoConfig diabetesLedgerDaoConfig;
    private final DaoConfig dictsDaoConfig;
    private final DaoConfig disabilityHearingDaoConfig;
    private final DaoConfig disabilityIntelligenceDaoConfig;
    private final DaoConfig disabilityLimbDaoConfig;
    private final DaoConfig disabilityVisualDaoConfig;
    private final DaoConfig buildingsDaoConfig;
    private final DaoConfig districtsDaoConfig;
    private final DaoConfig roomDaoConfig;
    private final DaoConfig subdistrictsDaoConfig;
    private final DaoConfig doctorDaoConfig;
    private final DaoConfig empDaoConfig;
    private final DaoConfig healthExamDaoConfig;
    private final DaoConfig healthExamDrugDaoConfig;
    private final DaoConfig healthExamInhosDaoConfig;
    private final DaoConfig healthExamNoplanVaccDaoConfig;
    private final DaoConfig agencyFamilyDaoConfig;
    private final DaoConfig familyDaoConfig;
    private final DaoConfig familyCredentialDaoConfig;
    private final DaoConfig familyDoctorDaoConfig;
    private final DaoConfig familyEconomicDaoConfig;
    private final DaoConfig familyInfoDaoConfig;
    private final DaoConfig familyMemberDaoConfig;
    private final DaoConfig familyMovedLogDaoConfig;
    private final DaoConfig hyperFollowupDaoConfig;
    private final DaoConfig hyperFollowupDrugDaoConfig;
    private final DaoConfig hyperInfoDaoConfig;
    private final DaoConfig hyperInfoDrugDaoConfig;
    private final DaoConfig hyperLedgerDaoConfig;
    private final DaoConfig maternalChildbirthDaoConfig;
    private final DaoConfig maternalFirstFollowupDaoConfig;
    private final DaoConfig maternalFollowupDaoConfig;
    private final DaoConfig maternalNewbornSituationDaoConfig;
    private final DaoConfig maternalPostpartumFollowupDaoConfig;
    private final DaoConfig maternalRegisterDaoConfig;
    private final DaoConfig maternalInfoDaoConfig;
    private final DaoConfig elderCognitionDaoConfig;
    private final DaoConfig elderDepressedDaoConfig;
    private final DaoConfig elderExamLedgerDaoConfig;
    private final DaoConfig elderInfoDaoConfig;
    private final DaoConfig elderSelfcareAbilityDaoConfig;
    private final DaoConfig elderTcmHealthDaoConfig;
    private final DaoConfig elderTcmLedgerDaoConfig;
    private final DaoConfig agencyPersonDaoConfig;
    private final DaoConfig memberMovedLogDaoConfig;
    private final DaoConfig personDaoConfig;
    private final DaoConfig personAddressDaoConfig;
    private final DaoConfig personCredentialDaoConfig;
    private final DaoConfig personDeathDaoConfig;
    private final DaoConfig personDiseaseDaoConfig;
    private final DaoConfig personInfoDaoConfig;
    private final DaoConfig personPastHistoryDaoConfig;
    private final DaoConfig personSerialNoDaoConfig;
    private final DaoConfig personServiceCatalogDaoConfig;
    private final DaoConfig recordChoiceDaoConfig;
    private final DaoConfig sickChoiceMedicineDaoConfig;
    private final DaoConfig sickMedicineDaoConfig;
    private final DaoConfig smiFollowupDaoConfig;
    private final DaoConfig smiFollowupDrugDaoConfig;
    private final DaoConfig smiInfoDaoConfig;
    private final DaoConfig termDaoConfig;
    private final DaoConfig tuberculosisFirstFollowupDaoConfig;
    private final DaoConfig tuberculosisFollowupDaoConfig;
    private final DaoConfig tuberculosisInfoDaoConfig;
    private final DaoConfig tuberculosisReferralDaoConfig;
    private final DaoConfig updateStateDaoConfig;
    private final DaoConfig cdcVaccreportDaoConfig;
    private final DaoConfig cdcVaccreportAdverseDaoConfig;
    private final DaoConfig cdcVaccreportVaccinateDaoConfig;
    private final DaoConfig orgChoiceVaccineDaoConfig;
    private final DaoConfig vaccineDaoConfig;
    private final DaoConfig vaccineBatchnoDaoConfig;
    private final DaoConfig vaccineInjectTimesDaoConfig;
    private final DaoConfig vaccineManufacturerDaoConfig;
    private final DaoConfig visitDetailDaoConfig;
    private final DaoConfig visitMedicineDaoConfig;
    private final DaoConfig sessionRspDaoConfig;

    private final AndroidFileRecordDao androidFileRecordDao;
    private final CaInfoDrugsDao caInfoDrugsDao;
    private final CerebralApoplexyFollowupDao cerebralApoplexyFollowupDao;
    private final CerebralApoplexyInfoDao cerebralApoplexyInfoDao;
    private final ChecksDao checksDao;
    private final ChildDeathDao childDeathDao;
    private final ChildDiseaseScreenDao childDiseaseScreenDao;
    private final ChildDiseaseScreenDiagDao childDiseaseScreenDiagDao;
    private final ChildDiseaseScreenResultDao childDiseaseScreenResultDao;
    private final ChildHealthExamDao childHealthExamDao;
    private final ChildHearScreenDao childHearScreenDao;
    private final ChildHomeVisitDao childHomeVisitDao;
    private final ChildInfoDao childInfoDao;
    private final ChildLedgerDao childLedgerDao;
    private final ChildPerinatalDeathDao childPerinatalDeathDao;
    private final ChildTcmLedgerDao childTcmLedgerDao;
    private final ChildWeakFollowupDao childWeakFollowupDao;
    private final ChildWeakInfoDao childWeakInfoDao;
    private final ColorsDao colorsDao;
    private final ChdInfoDrugsDao chdInfoDrugsDao;
    private final CoronaryHeartDiseaseFollowupDao coronaryHeartDiseaseFollowupDao;
    private final CoronaryHeartDiseaseInfoDao coronaryHeartDiseaseInfoDao;
    private final DiabetesFollowupDao diabetesFollowupDao;
    private final DiabetesFollowupDrugDao diabetesFollowupDrugDao;
    private final DiabetesInfoDao diabetesInfoDao;
    private final DiabetesInfoCompDao diabetesInfoCompDao;
    private final DiabetesInfoDrugDao diabetesInfoDrugDao;
    private final DiabetesLedgerDao diabetesLedgerDao;
    private final DictsDao dictsDao;
    private final DisabilityHearingDao disabilityHearingDao;
    private final DisabilityIntelligenceDao disabilityIntelligenceDao;
    private final DisabilityLimbDao disabilityLimbDao;
    private final DisabilityVisualDao disabilityVisualDao;
    private final BuildingsDao buildingsDao;
    private final DistrictsDao districtsDao;
    private final RoomDao roomDao;
    private final SubdistrictsDao subdistrictsDao;
    private final DoctorDao doctorDao;
    private final EmpDao empDao;
    private final HealthExamDao healthExamDao;
    private final HealthExamDrugDao healthExamDrugDao;
    private final HealthExamInhosDao healthExamInhosDao;
    private final HealthExamNoplanVaccDao healthExamNoplanVaccDao;
    private final AgencyFamilyDao agencyFamilyDao;
    private final FamilyDao familyDao;
    private final FamilyCredentialDao familyCredentialDao;
    private final FamilyDoctorDao familyDoctorDao;
    private final FamilyEconomicDao familyEconomicDao;
    private final FamilyInfoDao familyInfoDao;
    private final FamilyMemberDao familyMemberDao;
    private final FamilyMovedLogDao familyMovedLogDao;
    private final HyperFollowupDao hyperFollowupDao;
    private final HyperFollowupDrugDao hyperFollowupDrugDao;
    private final HyperInfoDao hyperInfoDao;
    private final HyperInfoDrugDao hyperInfoDrugDao;
    private final HyperLedgerDao hyperLedgerDao;
    private final MaternalChildbirthDao maternalChildbirthDao;
    private final MaternalFirstFollowupDao maternalFirstFollowupDao;
    private final MaternalFollowupDao maternalFollowupDao;
    private final MaternalNewbornSituationDao maternalNewbornSituationDao;
    private final MaternalPostpartumFollowupDao maternalPostpartumFollowupDao;
    private final MaternalRegisterDao maternalRegisterDao;
    private final MaternalInfoDao maternalInfoDao;
    private final ElderCognitionDao elderCognitionDao;
    private final ElderDepressedDao elderDepressedDao;
    private final ElderExamLedgerDao elderExamLedgerDao;
    private final ElderInfoDao elderInfoDao;
    private final ElderSelfcareAbilityDao elderSelfcareAbilityDao;
    private final ElderTcmHealthDao elderTcmHealthDao;
    private final ElderTcmLedgerDao elderTcmLedgerDao;
    private final AgencyPersonDao agencyPersonDao;
    private final MemberMovedLogDao memberMovedLogDao;
    private final PersonDao personDao;
    private final PersonAddressDao personAddressDao;
    private final PersonCredentialDao personCredentialDao;
    private final PersonDeathDao personDeathDao;
    private final PersonDiseaseDao personDiseaseDao;
    private final PersonInfoDao personInfoDao;
    private final PersonPastHistoryDao personPastHistoryDao;
    private final PersonSerialNoDao personSerialNoDao;
    private final PersonServiceCatalogDao personServiceCatalogDao;
    private final RecordChoiceDao recordChoiceDao;
    private final SickChoiceMedicineDao sickChoiceMedicineDao;
    private final SickMedicineDao sickMedicineDao;
    private final SmiFollowupDao smiFollowupDao;
    private final SmiFollowupDrugDao smiFollowupDrugDao;
    private final SmiInfoDao smiInfoDao;
    private final TermDao termDao;
    private final TuberculosisFirstFollowupDao tuberculosisFirstFollowupDao;
    private final TuberculosisFollowupDao tuberculosisFollowupDao;
    private final TuberculosisInfoDao tuberculosisInfoDao;
    private final TuberculosisReferralDao tuberculosisReferralDao;
    private final UpdateStateDao updateStateDao;
    private final CdcVaccreportDao cdcVaccreportDao;
    private final CdcVaccreportAdverseDao cdcVaccreportAdverseDao;
    private final CdcVaccreportVaccinateDao cdcVaccreportVaccinateDao;
    private final OrgChoiceVaccineDao orgChoiceVaccineDao;
    private final VaccineDao vaccineDao;
    private final VaccineBatchnoDao vaccineBatchnoDao;
    private final VaccineInjectTimesDao vaccineInjectTimesDao;
    private final VaccineManufacturerDao vaccineManufacturerDao;
    private final VisitDetailDao visitDetailDao;
    private final VisitMedicineDao visitMedicineDao;
    private final SessionRspDao sessionRspDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        androidFileRecordDaoConfig = daoConfigMap.get(AndroidFileRecordDao.class).clone();
        androidFileRecordDaoConfig.initIdentityScope(type);

        caInfoDrugsDaoConfig = daoConfigMap.get(CaInfoDrugsDao.class).clone();
        caInfoDrugsDaoConfig.initIdentityScope(type);

        cerebralApoplexyFollowupDaoConfig = daoConfigMap.get(CerebralApoplexyFollowupDao.class).clone();
        cerebralApoplexyFollowupDaoConfig.initIdentityScope(type);

        cerebralApoplexyInfoDaoConfig = daoConfigMap.get(CerebralApoplexyInfoDao.class).clone();
        cerebralApoplexyInfoDaoConfig.initIdentityScope(type);

        checksDaoConfig = daoConfigMap.get(ChecksDao.class).clone();
        checksDaoConfig.initIdentityScope(type);

        childDeathDaoConfig = daoConfigMap.get(ChildDeathDao.class).clone();
        childDeathDaoConfig.initIdentityScope(type);

        childDiseaseScreenDaoConfig = daoConfigMap.get(ChildDiseaseScreenDao.class).clone();
        childDiseaseScreenDaoConfig.initIdentityScope(type);

        childDiseaseScreenDiagDaoConfig = daoConfigMap.get(ChildDiseaseScreenDiagDao.class).clone();
        childDiseaseScreenDiagDaoConfig.initIdentityScope(type);

        childDiseaseScreenResultDaoConfig = daoConfigMap.get(ChildDiseaseScreenResultDao.class).clone();
        childDiseaseScreenResultDaoConfig.initIdentityScope(type);

        childHealthExamDaoConfig = daoConfigMap.get(ChildHealthExamDao.class).clone();
        childHealthExamDaoConfig.initIdentityScope(type);

        childHearScreenDaoConfig = daoConfigMap.get(ChildHearScreenDao.class).clone();
        childHearScreenDaoConfig.initIdentityScope(type);

        childHomeVisitDaoConfig = daoConfigMap.get(ChildHomeVisitDao.class).clone();
        childHomeVisitDaoConfig.initIdentityScope(type);

        childInfoDaoConfig = daoConfigMap.get(ChildInfoDao.class).clone();
        childInfoDaoConfig.initIdentityScope(type);

        childLedgerDaoConfig = daoConfigMap.get(ChildLedgerDao.class).clone();
        childLedgerDaoConfig.initIdentityScope(type);

        childPerinatalDeathDaoConfig = daoConfigMap.get(ChildPerinatalDeathDao.class).clone();
        childPerinatalDeathDaoConfig.initIdentityScope(type);

        childTcmLedgerDaoConfig = daoConfigMap.get(ChildTcmLedgerDao.class).clone();
        childTcmLedgerDaoConfig.initIdentityScope(type);

        childWeakFollowupDaoConfig = daoConfigMap.get(ChildWeakFollowupDao.class).clone();
        childWeakFollowupDaoConfig.initIdentityScope(type);

        childWeakInfoDaoConfig = daoConfigMap.get(ChildWeakInfoDao.class).clone();
        childWeakInfoDaoConfig.initIdentityScope(type);

        colorsDaoConfig = daoConfigMap.get(ColorsDao.class).clone();
        colorsDaoConfig.initIdentityScope(type);

        chdInfoDrugsDaoConfig = daoConfigMap.get(ChdInfoDrugsDao.class).clone();
        chdInfoDrugsDaoConfig.initIdentityScope(type);

        coronaryHeartDiseaseFollowupDaoConfig = daoConfigMap.get(CoronaryHeartDiseaseFollowupDao.class).clone();
        coronaryHeartDiseaseFollowupDaoConfig.initIdentityScope(type);

        coronaryHeartDiseaseInfoDaoConfig = daoConfigMap.get(CoronaryHeartDiseaseInfoDao.class).clone();
        coronaryHeartDiseaseInfoDaoConfig.initIdentityScope(type);

        diabetesFollowupDaoConfig = daoConfigMap.get(DiabetesFollowupDao.class).clone();
        diabetesFollowupDaoConfig.initIdentityScope(type);

        diabetesFollowupDrugDaoConfig = daoConfigMap.get(DiabetesFollowupDrugDao.class).clone();
        diabetesFollowupDrugDaoConfig.initIdentityScope(type);

        diabetesInfoDaoConfig = daoConfigMap.get(DiabetesInfoDao.class).clone();
        diabetesInfoDaoConfig.initIdentityScope(type);

        diabetesInfoCompDaoConfig = daoConfigMap.get(DiabetesInfoCompDao.class).clone();
        diabetesInfoCompDaoConfig.initIdentityScope(type);

        diabetesInfoDrugDaoConfig = daoConfigMap.get(DiabetesInfoDrugDao.class).clone();
        diabetesInfoDrugDaoConfig.initIdentityScope(type);

        diabetesLedgerDaoConfig = daoConfigMap.get(DiabetesLedgerDao.class).clone();
        diabetesLedgerDaoConfig.initIdentityScope(type);

        dictsDaoConfig = daoConfigMap.get(DictsDao.class).clone();
        dictsDaoConfig.initIdentityScope(type);

        disabilityHearingDaoConfig = daoConfigMap.get(DisabilityHearingDao.class).clone();
        disabilityHearingDaoConfig.initIdentityScope(type);

        disabilityIntelligenceDaoConfig = daoConfigMap.get(DisabilityIntelligenceDao.class).clone();
        disabilityIntelligenceDaoConfig.initIdentityScope(type);

        disabilityLimbDaoConfig = daoConfigMap.get(DisabilityLimbDao.class).clone();
        disabilityLimbDaoConfig.initIdentityScope(type);

        disabilityVisualDaoConfig = daoConfigMap.get(DisabilityVisualDao.class).clone();
        disabilityVisualDaoConfig.initIdentityScope(type);

        buildingsDaoConfig = daoConfigMap.get(BuildingsDao.class).clone();
        buildingsDaoConfig.initIdentityScope(type);

        districtsDaoConfig = daoConfigMap.get(DistrictsDao.class).clone();
        districtsDaoConfig.initIdentityScope(type);

        roomDaoConfig = daoConfigMap.get(RoomDao.class).clone();
        roomDaoConfig.initIdentityScope(type);

        subdistrictsDaoConfig = daoConfigMap.get(SubdistrictsDao.class).clone();
        subdistrictsDaoConfig.initIdentityScope(type);

        doctorDaoConfig = daoConfigMap.get(DoctorDao.class).clone();
        doctorDaoConfig.initIdentityScope(type);

        empDaoConfig = daoConfigMap.get(EmpDao.class).clone();
        empDaoConfig.initIdentityScope(type);

        healthExamDaoConfig = daoConfigMap.get(HealthExamDao.class).clone();
        healthExamDaoConfig.initIdentityScope(type);

        healthExamDrugDaoConfig = daoConfigMap.get(HealthExamDrugDao.class).clone();
        healthExamDrugDaoConfig.initIdentityScope(type);

        healthExamInhosDaoConfig = daoConfigMap.get(HealthExamInhosDao.class).clone();
        healthExamInhosDaoConfig.initIdentityScope(type);

        healthExamNoplanVaccDaoConfig = daoConfigMap.get(HealthExamNoplanVaccDao.class).clone();
        healthExamNoplanVaccDaoConfig.initIdentityScope(type);

        agencyFamilyDaoConfig = daoConfigMap.get(AgencyFamilyDao.class).clone();
        agencyFamilyDaoConfig.initIdentityScope(type);

        familyDaoConfig = daoConfigMap.get(FamilyDao.class).clone();
        familyDaoConfig.initIdentityScope(type);

        familyCredentialDaoConfig = daoConfigMap.get(FamilyCredentialDao.class).clone();
        familyCredentialDaoConfig.initIdentityScope(type);

        familyDoctorDaoConfig = daoConfigMap.get(FamilyDoctorDao.class).clone();
        familyDoctorDaoConfig.initIdentityScope(type);

        familyEconomicDaoConfig = daoConfigMap.get(FamilyEconomicDao.class).clone();
        familyEconomicDaoConfig.initIdentityScope(type);

        familyInfoDaoConfig = daoConfigMap.get(FamilyInfoDao.class).clone();
        familyInfoDaoConfig.initIdentityScope(type);

        familyMemberDaoConfig = daoConfigMap.get(FamilyMemberDao.class).clone();
        familyMemberDaoConfig.initIdentityScope(type);

        familyMovedLogDaoConfig = daoConfigMap.get(FamilyMovedLogDao.class).clone();
        familyMovedLogDaoConfig.initIdentityScope(type);

        hyperFollowupDaoConfig = daoConfigMap.get(HyperFollowupDao.class).clone();
        hyperFollowupDaoConfig.initIdentityScope(type);

        hyperFollowupDrugDaoConfig = daoConfigMap.get(HyperFollowupDrugDao.class).clone();
        hyperFollowupDrugDaoConfig.initIdentityScope(type);

        hyperInfoDaoConfig = daoConfigMap.get(HyperInfoDao.class).clone();
        hyperInfoDaoConfig.initIdentityScope(type);

        hyperInfoDrugDaoConfig = daoConfigMap.get(HyperInfoDrugDao.class).clone();
        hyperInfoDrugDaoConfig.initIdentityScope(type);

        hyperLedgerDaoConfig = daoConfigMap.get(HyperLedgerDao.class).clone();
        hyperLedgerDaoConfig.initIdentityScope(type);

        maternalChildbirthDaoConfig = daoConfigMap.get(MaternalChildbirthDao.class).clone();
        maternalChildbirthDaoConfig.initIdentityScope(type);

        maternalFirstFollowupDaoConfig = daoConfigMap.get(MaternalFirstFollowupDao.class).clone();
        maternalFirstFollowupDaoConfig.initIdentityScope(type);

        maternalFollowupDaoConfig = daoConfigMap.get(MaternalFollowupDao.class).clone();
        maternalFollowupDaoConfig.initIdentityScope(type);

        maternalNewbornSituationDaoConfig = daoConfigMap.get(MaternalNewbornSituationDao.class).clone();
        maternalNewbornSituationDaoConfig.initIdentityScope(type);

        maternalPostpartumFollowupDaoConfig = daoConfigMap.get(MaternalPostpartumFollowupDao.class).clone();
        maternalPostpartumFollowupDaoConfig.initIdentityScope(type);

        maternalRegisterDaoConfig = daoConfigMap.get(MaternalRegisterDao.class).clone();
        maternalRegisterDaoConfig.initIdentityScope(type);

        maternalInfoDaoConfig = daoConfigMap.get(MaternalInfoDao.class).clone();
        maternalInfoDaoConfig.initIdentityScope(type);

        elderCognitionDaoConfig = daoConfigMap.get(ElderCognitionDao.class).clone();
        elderCognitionDaoConfig.initIdentityScope(type);

        elderDepressedDaoConfig = daoConfigMap.get(ElderDepressedDao.class).clone();
        elderDepressedDaoConfig.initIdentityScope(type);

        elderExamLedgerDaoConfig = daoConfigMap.get(ElderExamLedgerDao.class).clone();
        elderExamLedgerDaoConfig.initIdentityScope(type);

        elderInfoDaoConfig = daoConfigMap.get(ElderInfoDao.class).clone();
        elderInfoDaoConfig.initIdentityScope(type);

        elderSelfcareAbilityDaoConfig = daoConfigMap.get(ElderSelfcareAbilityDao.class).clone();
        elderSelfcareAbilityDaoConfig.initIdentityScope(type);

        elderTcmHealthDaoConfig = daoConfigMap.get(ElderTcmHealthDao.class).clone();
        elderTcmHealthDaoConfig.initIdentityScope(type);

        elderTcmLedgerDaoConfig = daoConfigMap.get(ElderTcmLedgerDao.class).clone();
        elderTcmLedgerDaoConfig.initIdentityScope(type);

        agencyPersonDaoConfig = daoConfigMap.get(AgencyPersonDao.class).clone();
        agencyPersonDaoConfig.initIdentityScope(type);

        memberMovedLogDaoConfig = daoConfigMap.get(MemberMovedLogDao.class).clone();
        memberMovedLogDaoConfig.initIdentityScope(type);

        personDaoConfig = daoConfigMap.get(PersonDao.class).clone();
        personDaoConfig.initIdentityScope(type);

        personAddressDaoConfig = daoConfigMap.get(PersonAddressDao.class).clone();
        personAddressDaoConfig.initIdentityScope(type);

        personCredentialDaoConfig = daoConfigMap.get(PersonCredentialDao.class).clone();
        personCredentialDaoConfig.initIdentityScope(type);

        personDeathDaoConfig = daoConfigMap.get(PersonDeathDao.class).clone();
        personDeathDaoConfig.initIdentityScope(type);

        personDiseaseDaoConfig = daoConfigMap.get(PersonDiseaseDao.class).clone();
        personDiseaseDaoConfig.initIdentityScope(type);

        personInfoDaoConfig = daoConfigMap.get(PersonInfoDao.class).clone();
        personInfoDaoConfig.initIdentityScope(type);

        personPastHistoryDaoConfig = daoConfigMap.get(PersonPastHistoryDao.class).clone();
        personPastHistoryDaoConfig.initIdentityScope(type);

        personSerialNoDaoConfig = daoConfigMap.get(PersonSerialNoDao.class).clone();
        personSerialNoDaoConfig.initIdentityScope(type);

        personServiceCatalogDaoConfig = daoConfigMap.get(PersonServiceCatalogDao.class).clone();
        personServiceCatalogDaoConfig.initIdentityScope(type);

        recordChoiceDaoConfig = daoConfigMap.get(RecordChoiceDao.class).clone();
        recordChoiceDaoConfig.initIdentityScope(type);

        sickChoiceMedicineDaoConfig = daoConfigMap.get(SickChoiceMedicineDao.class).clone();
        sickChoiceMedicineDaoConfig.initIdentityScope(type);

        sickMedicineDaoConfig = daoConfigMap.get(SickMedicineDao.class).clone();
        sickMedicineDaoConfig.initIdentityScope(type);

        smiFollowupDaoConfig = daoConfigMap.get(SmiFollowupDao.class).clone();
        smiFollowupDaoConfig.initIdentityScope(type);

        smiFollowupDrugDaoConfig = daoConfigMap.get(SmiFollowupDrugDao.class).clone();
        smiFollowupDrugDaoConfig.initIdentityScope(type);

        smiInfoDaoConfig = daoConfigMap.get(SmiInfoDao.class).clone();
        smiInfoDaoConfig.initIdentityScope(type);

        termDaoConfig = daoConfigMap.get(TermDao.class).clone();
        termDaoConfig.initIdentityScope(type);

        tuberculosisFirstFollowupDaoConfig = daoConfigMap.get(TuberculosisFirstFollowupDao.class).clone();
        tuberculosisFirstFollowupDaoConfig.initIdentityScope(type);

        tuberculosisFollowupDaoConfig = daoConfigMap.get(TuberculosisFollowupDao.class).clone();
        tuberculosisFollowupDaoConfig.initIdentityScope(type);

        tuberculosisInfoDaoConfig = daoConfigMap.get(TuberculosisInfoDao.class).clone();
        tuberculosisInfoDaoConfig.initIdentityScope(type);

        tuberculosisReferralDaoConfig = daoConfigMap.get(TuberculosisReferralDao.class).clone();
        tuberculosisReferralDaoConfig.initIdentityScope(type);

        updateStateDaoConfig = daoConfigMap.get(UpdateStateDao.class).clone();
        updateStateDaoConfig.initIdentityScope(type);

        cdcVaccreportDaoConfig = daoConfigMap.get(CdcVaccreportDao.class).clone();
        cdcVaccreportDaoConfig.initIdentityScope(type);

        cdcVaccreportAdverseDaoConfig = daoConfigMap.get(CdcVaccreportAdverseDao.class).clone();
        cdcVaccreportAdverseDaoConfig.initIdentityScope(type);

        cdcVaccreportVaccinateDaoConfig = daoConfigMap.get(CdcVaccreportVaccinateDao.class).clone();
        cdcVaccreportVaccinateDaoConfig.initIdentityScope(type);

        orgChoiceVaccineDaoConfig = daoConfigMap.get(OrgChoiceVaccineDao.class).clone();
        orgChoiceVaccineDaoConfig.initIdentityScope(type);

        vaccineDaoConfig = daoConfigMap.get(VaccineDao.class).clone();
        vaccineDaoConfig.initIdentityScope(type);

        vaccineBatchnoDaoConfig = daoConfigMap.get(VaccineBatchnoDao.class).clone();
        vaccineBatchnoDaoConfig.initIdentityScope(type);

        vaccineInjectTimesDaoConfig = daoConfigMap.get(VaccineInjectTimesDao.class).clone();
        vaccineInjectTimesDaoConfig.initIdentityScope(type);

        vaccineManufacturerDaoConfig = daoConfigMap.get(VaccineManufacturerDao.class).clone();
        vaccineManufacturerDaoConfig.initIdentityScope(type);

        visitDetailDaoConfig = daoConfigMap.get(VisitDetailDao.class).clone();
        visitDetailDaoConfig.initIdentityScope(type);

        visitMedicineDaoConfig = daoConfigMap.get(VisitMedicineDao.class).clone();
        visitMedicineDaoConfig.initIdentityScope(type);

        sessionRspDaoConfig = daoConfigMap.get(SessionRspDao.class).clone();
        sessionRspDaoConfig.initIdentityScope(type);

        androidFileRecordDao = new AndroidFileRecordDao(androidFileRecordDaoConfig, this);
        caInfoDrugsDao = new CaInfoDrugsDao(caInfoDrugsDaoConfig, this);
        cerebralApoplexyFollowupDao = new CerebralApoplexyFollowupDao(cerebralApoplexyFollowupDaoConfig, this);
        cerebralApoplexyInfoDao = new CerebralApoplexyInfoDao(cerebralApoplexyInfoDaoConfig, this);
        checksDao = new ChecksDao(checksDaoConfig, this);
        childDeathDao = new ChildDeathDao(childDeathDaoConfig, this);
        childDiseaseScreenDao = new ChildDiseaseScreenDao(childDiseaseScreenDaoConfig, this);
        childDiseaseScreenDiagDao = new ChildDiseaseScreenDiagDao(childDiseaseScreenDiagDaoConfig, this);
        childDiseaseScreenResultDao = new ChildDiseaseScreenResultDao(childDiseaseScreenResultDaoConfig, this);
        childHealthExamDao = new ChildHealthExamDao(childHealthExamDaoConfig, this);
        childHearScreenDao = new ChildHearScreenDao(childHearScreenDaoConfig, this);
        childHomeVisitDao = new ChildHomeVisitDao(childHomeVisitDaoConfig, this);
        childInfoDao = new ChildInfoDao(childInfoDaoConfig, this);
        childLedgerDao = new ChildLedgerDao(childLedgerDaoConfig, this);
        childPerinatalDeathDao = new ChildPerinatalDeathDao(childPerinatalDeathDaoConfig, this);
        childTcmLedgerDao = new ChildTcmLedgerDao(childTcmLedgerDaoConfig, this);
        childWeakFollowupDao = new ChildWeakFollowupDao(childWeakFollowupDaoConfig, this);
        childWeakInfoDao = new ChildWeakInfoDao(childWeakInfoDaoConfig, this);
        colorsDao = new ColorsDao(colorsDaoConfig, this);
        chdInfoDrugsDao = new ChdInfoDrugsDao(chdInfoDrugsDaoConfig, this);
        coronaryHeartDiseaseFollowupDao = new CoronaryHeartDiseaseFollowupDao(coronaryHeartDiseaseFollowupDaoConfig, this);
        coronaryHeartDiseaseInfoDao = new CoronaryHeartDiseaseInfoDao(coronaryHeartDiseaseInfoDaoConfig, this);
        diabetesFollowupDao = new DiabetesFollowupDao(diabetesFollowupDaoConfig, this);
        diabetesFollowupDrugDao = new DiabetesFollowupDrugDao(diabetesFollowupDrugDaoConfig, this);
        diabetesInfoDao = new DiabetesInfoDao(diabetesInfoDaoConfig, this);
        diabetesInfoCompDao = new DiabetesInfoCompDao(diabetesInfoCompDaoConfig, this);
        diabetesInfoDrugDao = new DiabetesInfoDrugDao(diabetesInfoDrugDaoConfig, this);
        diabetesLedgerDao = new DiabetesLedgerDao(diabetesLedgerDaoConfig, this);
        dictsDao = new DictsDao(dictsDaoConfig, this);
        disabilityHearingDao = new DisabilityHearingDao(disabilityHearingDaoConfig, this);
        disabilityIntelligenceDao = new DisabilityIntelligenceDao(disabilityIntelligenceDaoConfig, this);
        disabilityLimbDao = new DisabilityLimbDao(disabilityLimbDaoConfig, this);
        disabilityVisualDao = new DisabilityVisualDao(disabilityVisualDaoConfig, this);
        buildingsDao = new BuildingsDao(buildingsDaoConfig, this);
        districtsDao = new DistrictsDao(districtsDaoConfig, this);
        roomDao = new RoomDao(roomDaoConfig, this);
        subdistrictsDao = new SubdistrictsDao(subdistrictsDaoConfig, this);
        doctorDao = new DoctorDao(doctorDaoConfig, this);
        empDao = new EmpDao(empDaoConfig, this);
        healthExamDao = new HealthExamDao(healthExamDaoConfig, this);
        healthExamDrugDao = new HealthExamDrugDao(healthExamDrugDaoConfig, this);
        healthExamInhosDao = new HealthExamInhosDao(healthExamInhosDaoConfig, this);
        healthExamNoplanVaccDao = new HealthExamNoplanVaccDao(healthExamNoplanVaccDaoConfig, this);
        agencyFamilyDao = new AgencyFamilyDao(agencyFamilyDaoConfig, this);
        familyDao = new FamilyDao(familyDaoConfig, this);
        familyCredentialDao = new FamilyCredentialDao(familyCredentialDaoConfig, this);
        familyDoctorDao = new FamilyDoctorDao(familyDoctorDaoConfig, this);
        familyEconomicDao = new FamilyEconomicDao(familyEconomicDaoConfig, this);
        familyInfoDao = new FamilyInfoDao(familyInfoDaoConfig, this);
        familyMemberDao = new FamilyMemberDao(familyMemberDaoConfig, this);
        familyMovedLogDao = new FamilyMovedLogDao(familyMovedLogDaoConfig, this);
        hyperFollowupDao = new HyperFollowupDao(hyperFollowupDaoConfig, this);
        hyperFollowupDrugDao = new HyperFollowupDrugDao(hyperFollowupDrugDaoConfig, this);
        hyperInfoDao = new HyperInfoDao(hyperInfoDaoConfig, this);
        hyperInfoDrugDao = new HyperInfoDrugDao(hyperInfoDrugDaoConfig, this);
        hyperLedgerDao = new HyperLedgerDao(hyperLedgerDaoConfig, this);
        maternalChildbirthDao = new MaternalChildbirthDao(maternalChildbirthDaoConfig, this);
        maternalFirstFollowupDao = new MaternalFirstFollowupDao(maternalFirstFollowupDaoConfig, this);
        maternalFollowupDao = new MaternalFollowupDao(maternalFollowupDaoConfig, this);
        maternalNewbornSituationDao = new MaternalNewbornSituationDao(maternalNewbornSituationDaoConfig, this);
        maternalPostpartumFollowupDao = new MaternalPostpartumFollowupDao(maternalPostpartumFollowupDaoConfig, this);
        maternalRegisterDao = new MaternalRegisterDao(maternalRegisterDaoConfig, this);
        maternalInfoDao = new MaternalInfoDao(maternalInfoDaoConfig, this);
        elderCognitionDao = new ElderCognitionDao(elderCognitionDaoConfig, this);
        elderDepressedDao = new ElderDepressedDao(elderDepressedDaoConfig, this);
        elderExamLedgerDao = new ElderExamLedgerDao(elderExamLedgerDaoConfig, this);
        elderInfoDao = new ElderInfoDao(elderInfoDaoConfig, this);
        elderSelfcareAbilityDao = new ElderSelfcareAbilityDao(elderSelfcareAbilityDaoConfig, this);
        elderTcmHealthDao = new ElderTcmHealthDao(elderTcmHealthDaoConfig, this);
        elderTcmLedgerDao = new ElderTcmLedgerDao(elderTcmLedgerDaoConfig, this);
        agencyPersonDao = new AgencyPersonDao(agencyPersonDaoConfig, this);
        memberMovedLogDao = new MemberMovedLogDao(memberMovedLogDaoConfig, this);
        personDao = new PersonDao(personDaoConfig, this);
        personAddressDao = new PersonAddressDao(personAddressDaoConfig, this);
        personCredentialDao = new PersonCredentialDao(personCredentialDaoConfig, this);
        personDeathDao = new PersonDeathDao(personDeathDaoConfig, this);
        personDiseaseDao = new PersonDiseaseDao(personDiseaseDaoConfig, this);
        personInfoDao = new PersonInfoDao(personInfoDaoConfig, this);
        personPastHistoryDao = new PersonPastHistoryDao(personPastHistoryDaoConfig, this);
        personSerialNoDao = new PersonSerialNoDao(personSerialNoDaoConfig, this);
        personServiceCatalogDao = new PersonServiceCatalogDao(personServiceCatalogDaoConfig, this);
        recordChoiceDao = new RecordChoiceDao(recordChoiceDaoConfig, this);
        sickChoiceMedicineDao = new SickChoiceMedicineDao(sickChoiceMedicineDaoConfig, this);
        sickMedicineDao = new SickMedicineDao(sickMedicineDaoConfig, this);
        smiFollowupDao = new SmiFollowupDao(smiFollowupDaoConfig, this);
        smiFollowupDrugDao = new SmiFollowupDrugDao(smiFollowupDrugDaoConfig, this);
        smiInfoDao = new SmiInfoDao(smiInfoDaoConfig, this);
        termDao = new TermDao(termDaoConfig, this);
        tuberculosisFirstFollowupDao = new TuberculosisFirstFollowupDao(tuberculosisFirstFollowupDaoConfig, this);
        tuberculosisFollowupDao = new TuberculosisFollowupDao(tuberculosisFollowupDaoConfig, this);
        tuberculosisInfoDao = new TuberculosisInfoDao(tuberculosisInfoDaoConfig, this);
        tuberculosisReferralDao = new TuberculosisReferralDao(tuberculosisReferralDaoConfig, this);
        updateStateDao = new UpdateStateDao(updateStateDaoConfig, this);
        cdcVaccreportDao = new CdcVaccreportDao(cdcVaccreportDaoConfig, this);
        cdcVaccreportAdverseDao = new CdcVaccreportAdverseDao(cdcVaccreportAdverseDaoConfig, this);
        cdcVaccreportVaccinateDao = new CdcVaccreportVaccinateDao(cdcVaccreportVaccinateDaoConfig, this);
        orgChoiceVaccineDao = new OrgChoiceVaccineDao(orgChoiceVaccineDaoConfig, this);
        vaccineDao = new VaccineDao(vaccineDaoConfig, this);
        vaccineBatchnoDao = new VaccineBatchnoDao(vaccineBatchnoDaoConfig, this);
        vaccineInjectTimesDao = new VaccineInjectTimesDao(vaccineInjectTimesDaoConfig, this);
        vaccineManufacturerDao = new VaccineManufacturerDao(vaccineManufacturerDaoConfig, this);
        visitDetailDao = new VisitDetailDao(visitDetailDaoConfig, this);
        visitMedicineDao = new VisitMedicineDao(visitMedicineDaoConfig, this);
        sessionRspDao = new SessionRspDao(sessionRspDaoConfig, this);

        registerDao(AndroidFileRecord.class, androidFileRecordDao);
        registerDao(CaInfoDrugs.class, caInfoDrugsDao);
        registerDao(CerebralApoplexyFollowup.class, cerebralApoplexyFollowupDao);
        registerDao(CerebralApoplexyInfo.class, cerebralApoplexyInfoDao);
        registerDao(Checks.class, checksDao);
        registerDao(ChildDeath.class, childDeathDao);
        registerDao(ChildDiseaseScreen.class, childDiseaseScreenDao);
        registerDao(ChildDiseaseScreenDiag.class, childDiseaseScreenDiagDao);
        registerDao(ChildDiseaseScreenResult.class, childDiseaseScreenResultDao);
        registerDao(ChildHealthExam.class, childHealthExamDao);
        registerDao(ChildHearScreen.class, childHearScreenDao);
        registerDao(ChildHomeVisit.class, childHomeVisitDao);
        registerDao(ChildInfo.class, childInfoDao);
        registerDao(ChildLedger.class, childLedgerDao);
        registerDao(ChildPerinatalDeath.class, childPerinatalDeathDao);
        registerDao(ChildTcmLedger.class, childTcmLedgerDao);
        registerDao(ChildWeakFollowup.class, childWeakFollowupDao);
        registerDao(ChildWeakInfo.class, childWeakInfoDao);
        registerDao(Colors.class, colorsDao);
        registerDao(ChdInfoDrugs.class, chdInfoDrugsDao);
        registerDao(CoronaryHeartDiseaseFollowup.class, coronaryHeartDiseaseFollowupDao);
        registerDao(CoronaryHeartDiseaseInfo.class, coronaryHeartDiseaseInfoDao);
        registerDao(DiabetesFollowup.class, diabetesFollowupDao);
        registerDao(DiabetesFollowupDrug.class, diabetesFollowupDrugDao);
        registerDao(DiabetesInfo.class, diabetesInfoDao);
        registerDao(DiabetesInfoComp.class, diabetesInfoCompDao);
        registerDao(DiabetesInfoDrug.class, diabetesInfoDrugDao);
        registerDao(DiabetesLedger.class, diabetesLedgerDao);
        registerDao(Dicts.class, dictsDao);
        registerDao(DisabilityHearing.class, disabilityHearingDao);
        registerDao(DisabilityIntelligence.class, disabilityIntelligenceDao);
        registerDao(DisabilityLimb.class, disabilityLimbDao);
        registerDao(DisabilityVisual.class, disabilityVisualDao);
        registerDao(Buildings.class, buildingsDao);
        registerDao(Districts.class, districtsDao);
        registerDao(Room.class, roomDao);
        registerDao(Subdistricts.class, subdistrictsDao);
        registerDao(Doctor.class, doctorDao);
        registerDao(Emp.class, empDao);
        registerDao(HealthExam.class, healthExamDao);
        registerDao(HealthExamDrug.class, healthExamDrugDao);
        registerDao(HealthExamInhos.class, healthExamInhosDao);
        registerDao(HealthExamNoplanVacc.class, healthExamNoplanVaccDao);
        registerDao(AgencyFamily.class, agencyFamilyDao);
        registerDao(Family.class, familyDao);
        registerDao(FamilyCredential.class, familyCredentialDao);
        registerDao(FamilyDoctor.class, familyDoctorDao);
        registerDao(FamilyEconomic.class, familyEconomicDao);
        registerDao(FamilyInfo.class, familyInfoDao);
        registerDao(FamilyMember.class, familyMemberDao);
        registerDao(FamilyMovedLog.class, familyMovedLogDao);
        registerDao(HyperFollowup.class, hyperFollowupDao);
        registerDao(HyperFollowupDrug.class, hyperFollowupDrugDao);
        registerDao(HyperInfo.class, hyperInfoDao);
        registerDao(HyperInfoDrug.class, hyperInfoDrugDao);
        registerDao(HyperLedger.class, hyperLedgerDao);
        registerDao(MaternalChildbirth.class, maternalChildbirthDao);
        registerDao(MaternalFirstFollowup.class, maternalFirstFollowupDao);
        registerDao(MaternalFollowup.class, maternalFollowupDao);
        registerDao(MaternalNewbornSituation.class, maternalNewbornSituationDao);
        registerDao(MaternalPostpartumFollowup.class, maternalPostpartumFollowupDao);
        registerDao(MaternalRegister.class, maternalRegisterDao);
        registerDao(MaternalInfo.class, maternalInfoDao);
        registerDao(ElderCognition.class, elderCognitionDao);
        registerDao(ElderDepressed.class, elderDepressedDao);
        registerDao(ElderExamLedger.class, elderExamLedgerDao);
        registerDao(ElderInfo.class, elderInfoDao);
        registerDao(ElderSelfcareAbility.class, elderSelfcareAbilityDao);
        registerDao(ElderTcmHealth.class, elderTcmHealthDao);
        registerDao(ElderTcmLedger.class, elderTcmLedgerDao);
        registerDao(AgencyPerson.class, agencyPersonDao);
        registerDao(MemberMovedLog.class, memberMovedLogDao);
        registerDao(Person.class, personDao);
        registerDao(PersonAddress.class, personAddressDao);
        registerDao(PersonCredential.class, personCredentialDao);
        registerDao(PersonDeath.class, personDeathDao);
        registerDao(PersonDisease.class, personDiseaseDao);
        registerDao(PersonInfo.class, personInfoDao);
        registerDao(PersonPastHistory.class, personPastHistoryDao);
        registerDao(PersonSerialNo.class, personSerialNoDao);
        registerDao(PersonServiceCatalog.class, personServiceCatalogDao);
        registerDao(RecordChoice.class, recordChoiceDao);
        registerDao(SickChoiceMedicine.class, sickChoiceMedicineDao);
        registerDao(SickMedicine.class, sickMedicineDao);
        registerDao(SmiFollowup.class, smiFollowupDao);
        registerDao(SmiFollowupDrug.class, smiFollowupDrugDao);
        registerDao(SmiInfo.class, smiInfoDao);
        registerDao(Term.class, termDao);
        registerDao(TuberculosisFirstFollowup.class, tuberculosisFirstFollowupDao);
        registerDao(TuberculosisFollowup.class, tuberculosisFollowupDao);
        registerDao(TuberculosisInfo.class, tuberculosisInfoDao);
        registerDao(TuberculosisReferral.class, tuberculosisReferralDao);
        registerDao(UpdateState.class, updateStateDao);
        registerDao(CdcVaccreport.class, cdcVaccreportDao);
        registerDao(CdcVaccreportAdverse.class, cdcVaccreportAdverseDao);
        registerDao(CdcVaccreportVaccinate.class, cdcVaccreportVaccinateDao);
        registerDao(OrgChoiceVaccine.class, orgChoiceVaccineDao);
        registerDao(Vaccine.class, vaccineDao);
        registerDao(VaccineBatchno.class, vaccineBatchnoDao);
        registerDao(VaccineInjectTimes.class, vaccineInjectTimesDao);
        registerDao(VaccineManufacturer.class, vaccineManufacturerDao);
        registerDao(VisitDetail.class, visitDetailDao);
        registerDao(VisitMedicine.class, visitMedicineDao);
        registerDao(SessionRsp.class, sessionRspDao);
    }
    
    public void clear() {
        androidFileRecordDaoConfig.getIdentityScope().clear();
        caInfoDrugsDaoConfig.getIdentityScope().clear();
        cerebralApoplexyFollowupDaoConfig.getIdentityScope().clear();
        cerebralApoplexyInfoDaoConfig.getIdentityScope().clear();
        checksDaoConfig.getIdentityScope().clear();
        childDeathDaoConfig.getIdentityScope().clear();
        childDiseaseScreenDaoConfig.getIdentityScope().clear();
        childDiseaseScreenDiagDaoConfig.getIdentityScope().clear();
        childDiseaseScreenResultDaoConfig.getIdentityScope().clear();
        childHealthExamDaoConfig.getIdentityScope().clear();
        childHearScreenDaoConfig.getIdentityScope().clear();
        childHomeVisitDaoConfig.getIdentityScope().clear();
        childInfoDaoConfig.getIdentityScope().clear();
        childLedgerDaoConfig.getIdentityScope().clear();
        childPerinatalDeathDaoConfig.getIdentityScope().clear();
        childTcmLedgerDaoConfig.getIdentityScope().clear();
        childWeakFollowupDaoConfig.getIdentityScope().clear();
        childWeakInfoDaoConfig.getIdentityScope().clear();
        colorsDaoConfig.getIdentityScope().clear();
        chdInfoDrugsDaoConfig.getIdentityScope().clear();
        coronaryHeartDiseaseFollowupDaoConfig.getIdentityScope().clear();
        coronaryHeartDiseaseInfoDaoConfig.getIdentityScope().clear();
        diabetesFollowupDaoConfig.getIdentityScope().clear();
        diabetesFollowupDrugDaoConfig.getIdentityScope().clear();
        diabetesInfoDaoConfig.getIdentityScope().clear();
        diabetesInfoCompDaoConfig.getIdentityScope().clear();
        diabetesInfoDrugDaoConfig.getIdentityScope().clear();
        diabetesLedgerDaoConfig.getIdentityScope().clear();
        dictsDaoConfig.getIdentityScope().clear();
        disabilityHearingDaoConfig.getIdentityScope().clear();
        disabilityIntelligenceDaoConfig.getIdentityScope().clear();
        disabilityLimbDaoConfig.getIdentityScope().clear();
        disabilityVisualDaoConfig.getIdentityScope().clear();
        buildingsDaoConfig.getIdentityScope().clear();
        districtsDaoConfig.getIdentityScope().clear();
        roomDaoConfig.getIdentityScope().clear();
        subdistrictsDaoConfig.getIdentityScope().clear();
        doctorDaoConfig.getIdentityScope().clear();
        empDaoConfig.getIdentityScope().clear();
        healthExamDaoConfig.getIdentityScope().clear();
        healthExamDrugDaoConfig.getIdentityScope().clear();
        healthExamInhosDaoConfig.getIdentityScope().clear();
        healthExamNoplanVaccDaoConfig.getIdentityScope().clear();
        agencyFamilyDaoConfig.getIdentityScope().clear();
        familyDaoConfig.getIdentityScope().clear();
        familyCredentialDaoConfig.getIdentityScope().clear();
        familyDoctorDaoConfig.getIdentityScope().clear();
        familyEconomicDaoConfig.getIdentityScope().clear();
        familyInfoDaoConfig.getIdentityScope().clear();
        familyMemberDaoConfig.getIdentityScope().clear();
        familyMovedLogDaoConfig.getIdentityScope().clear();
        hyperFollowupDaoConfig.getIdentityScope().clear();
        hyperFollowupDrugDaoConfig.getIdentityScope().clear();
        hyperInfoDaoConfig.getIdentityScope().clear();
        hyperInfoDrugDaoConfig.getIdentityScope().clear();
        hyperLedgerDaoConfig.getIdentityScope().clear();
        maternalChildbirthDaoConfig.getIdentityScope().clear();
        maternalFirstFollowupDaoConfig.getIdentityScope().clear();
        maternalFollowupDaoConfig.getIdentityScope().clear();
        maternalNewbornSituationDaoConfig.getIdentityScope().clear();
        maternalPostpartumFollowupDaoConfig.getIdentityScope().clear();
        maternalRegisterDaoConfig.getIdentityScope().clear();
        maternalInfoDaoConfig.getIdentityScope().clear();
        elderCognitionDaoConfig.getIdentityScope().clear();
        elderDepressedDaoConfig.getIdentityScope().clear();
        elderExamLedgerDaoConfig.getIdentityScope().clear();
        elderInfoDaoConfig.getIdentityScope().clear();
        elderSelfcareAbilityDaoConfig.getIdentityScope().clear();
        elderTcmHealthDaoConfig.getIdentityScope().clear();
        elderTcmLedgerDaoConfig.getIdentityScope().clear();
        agencyPersonDaoConfig.getIdentityScope().clear();
        memberMovedLogDaoConfig.getIdentityScope().clear();
        personDaoConfig.getIdentityScope().clear();
        personAddressDaoConfig.getIdentityScope().clear();
        personCredentialDaoConfig.getIdentityScope().clear();
        personDeathDaoConfig.getIdentityScope().clear();
        personDiseaseDaoConfig.getIdentityScope().clear();
        personInfoDaoConfig.getIdentityScope().clear();
        personPastHistoryDaoConfig.getIdentityScope().clear();
        personSerialNoDaoConfig.getIdentityScope().clear();
        personServiceCatalogDaoConfig.getIdentityScope().clear();
        recordChoiceDaoConfig.getIdentityScope().clear();
        sickChoiceMedicineDaoConfig.getIdentityScope().clear();
        sickMedicineDaoConfig.getIdentityScope().clear();
        smiFollowupDaoConfig.getIdentityScope().clear();
        smiFollowupDrugDaoConfig.getIdentityScope().clear();
        smiInfoDaoConfig.getIdentityScope().clear();
        termDaoConfig.getIdentityScope().clear();
        tuberculosisFirstFollowupDaoConfig.getIdentityScope().clear();
        tuberculosisFollowupDaoConfig.getIdentityScope().clear();
        tuberculosisInfoDaoConfig.getIdentityScope().clear();
        tuberculosisReferralDaoConfig.getIdentityScope().clear();
        updateStateDaoConfig.getIdentityScope().clear();
        cdcVaccreportDaoConfig.getIdentityScope().clear();
        cdcVaccreportAdverseDaoConfig.getIdentityScope().clear();
        cdcVaccreportVaccinateDaoConfig.getIdentityScope().clear();
        orgChoiceVaccineDaoConfig.getIdentityScope().clear();
        vaccineDaoConfig.getIdentityScope().clear();
        vaccineBatchnoDaoConfig.getIdentityScope().clear();
        vaccineInjectTimesDaoConfig.getIdentityScope().clear();
        vaccineManufacturerDaoConfig.getIdentityScope().clear();
        visitDetailDaoConfig.getIdentityScope().clear();
        visitMedicineDaoConfig.getIdentityScope().clear();
        sessionRspDaoConfig.getIdentityScope().clear();
    }

    public AndroidFileRecordDao getAndroidFileRecordDao() {
        return androidFileRecordDao;
    }

    public CaInfoDrugsDao getCaInfoDrugsDao() {
        return caInfoDrugsDao;
    }

    public CerebralApoplexyFollowupDao getCerebralApoplexyFollowupDao() {
        return cerebralApoplexyFollowupDao;
    }

    public CerebralApoplexyInfoDao getCerebralApoplexyInfoDao() {
        return cerebralApoplexyInfoDao;
    }

    public ChecksDao getChecksDao() {
        return checksDao;
    }

    public ChildDeathDao getChildDeathDao() {
        return childDeathDao;
    }

    public ChildDiseaseScreenDao getChildDiseaseScreenDao() {
        return childDiseaseScreenDao;
    }

    public ChildDiseaseScreenDiagDao getChildDiseaseScreenDiagDao() {
        return childDiseaseScreenDiagDao;
    }

    public ChildDiseaseScreenResultDao getChildDiseaseScreenResultDao() {
        return childDiseaseScreenResultDao;
    }

    public ChildHealthExamDao getChildHealthExamDao() {
        return childHealthExamDao;
    }

    public ChildHearScreenDao getChildHearScreenDao() {
        return childHearScreenDao;
    }

    public ChildHomeVisitDao getChildHomeVisitDao() {
        return childHomeVisitDao;
    }

    public ChildInfoDao getChildInfoDao() {
        return childInfoDao;
    }

    public ChildLedgerDao getChildLedgerDao() {
        return childLedgerDao;
    }

    public ChildPerinatalDeathDao getChildPerinatalDeathDao() {
        return childPerinatalDeathDao;
    }

    public ChildTcmLedgerDao getChildTcmLedgerDao() {
        return childTcmLedgerDao;
    }

    public ChildWeakFollowupDao getChildWeakFollowupDao() {
        return childWeakFollowupDao;
    }

    public ChildWeakInfoDao getChildWeakInfoDao() {
        return childWeakInfoDao;
    }

    public ColorsDao getColorsDao() {
        return colorsDao;
    }

    public ChdInfoDrugsDao getChdInfoDrugsDao() {
        return chdInfoDrugsDao;
    }

    public CoronaryHeartDiseaseFollowupDao getCoronaryHeartDiseaseFollowupDao() {
        return coronaryHeartDiseaseFollowupDao;
    }

    public CoronaryHeartDiseaseInfoDao getCoronaryHeartDiseaseInfoDao() {
        return coronaryHeartDiseaseInfoDao;
    }

    public DiabetesFollowupDao getDiabetesFollowupDao() {
        return diabetesFollowupDao;
    }

    public DiabetesFollowupDrugDao getDiabetesFollowupDrugDao() {
        return diabetesFollowupDrugDao;
    }

    public DiabetesInfoDao getDiabetesInfoDao() {
        return diabetesInfoDao;
    }

    public DiabetesInfoCompDao getDiabetesInfoCompDao() {
        return diabetesInfoCompDao;
    }

    public DiabetesInfoDrugDao getDiabetesInfoDrugDao() {
        return diabetesInfoDrugDao;
    }

    public DiabetesLedgerDao getDiabetesLedgerDao() {
        return diabetesLedgerDao;
    }

    public DictsDao getDictsDao() {
        return dictsDao;
    }

    public DisabilityHearingDao getDisabilityHearingDao() {
        return disabilityHearingDao;
    }

    public DisabilityIntelligenceDao getDisabilityIntelligenceDao() {
        return disabilityIntelligenceDao;
    }

    public DisabilityLimbDao getDisabilityLimbDao() {
        return disabilityLimbDao;
    }

    public DisabilityVisualDao getDisabilityVisualDao() {
        return disabilityVisualDao;
    }

    public BuildingsDao getBuildingsDao() {
        return buildingsDao;
    }

    public DistrictsDao getDistrictsDao() {
        return districtsDao;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    public SubdistrictsDao getSubdistrictsDao() {
        return subdistrictsDao;
    }

    public DoctorDao getDoctorDao() {
        return doctorDao;
    }

    public EmpDao getEmpDao() {
        return empDao;
    }

    public HealthExamDao getHealthExamDao() {
        return healthExamDao;
    }

    public HealthExamDrugDao getHealthExamDrugDao() {
        return healthExamDrugDao;
    }

    public HealthExamInhosDao getHealthExamInhosDao() {
        return healthExamInhosDao;
    }

    public HealthExamNoplanVaccDao getHealthExamNoplanVaccDao() {
        return healthExamNoplanVaccDao;
    }

    public AgencyFamilyDao getAgencyFamilyDao() {
        return agencyFamilyDao;
    }

    public FamilyDao getFamilyDao() {
        return familyDao;
    }

    public FamilyCredentialDao getFamilyCredentialDao() {
        return familyCredentialDao;
    }

    public FamilyDoctorDao getFamilyDoctorDao() {
        return familyDoctorDao;
    }

    public FamilyEconomicDao getFamilyEconomicDao() {
        return familyEconomicDao;
    }

    public FamilyInfoDao getFamilyInfoDao() {
        return familyInfoDao;
    }

    public FamilyMemberDao getFamilyMemberDao() {
        return familyMemberDao;
    }

    public FamilyMovedLogDao getFamilyMovedLogDao() {
        return familyMovedLogDao;
    }

    public HyperFollowupDao getHyperFollowupDao() {
        return hyperFollowupDao;
    }

    public HyperFollowupDrugDao getHyperFollowupDrugDao() {
        return hyperFollowupDrugDao;
    }

    public HyperInfoDao getHyperInfoDao() {
        return hyperInfoDao;
    }

    public HyperInfoDrugDao getHyperInfoDrugDao() {
        return hyperInfoDrugDao;
    }

    public HyperLedgerDao getHyperLedgerDao() {
        return hyperLedgerDao;
    }

    public MaternalChildbirthDao getMaternalChildbirthDao() {
        return maternalChildbirthDao;
    }

    public MaternalFirstFollowupDao getMaternalFirstFollowupDao() {
        return maternalFirstFollowupDao;
    }

    public MaternalFollowupDao getMaternalFollowupDao() {
        return maternalFollowupDao;
    }

    public MaternalNewbornSituationDao getMaternalNewbornSituationDao() {
        return maternalNewbornSituationDao;
    }

    public MaternalPostpartumFollowupDao getMaternalPostpartumFollowupDao() {
        return maternalPostpartumFollowupDao;
    }

    public MaternalRegisterDao getMaternalRegisterDao() {
        return maternalRegisterDao;
    }

    public MaternalInfoDao getMaternalInfoDao() {
        return maternalInfoDao;
    }

    public ElderCognitionDao getElderCognitionDao() {
        return elderCognitionDao;
    }

    public ElderDepressedDao getElderDepressedDao() {
        return elderDepressedDao;
    }

    public ElderExamLedgerDao getElderExamLedgerDao() {
        return elderExamLedgerDao;
    }

    public ElderInfoDao getElderInfoDao() {
        return elderInfoDao;
    }

    public ElderSelfcareAbilityDao getElderSelfcareAbilityDao() {
        return elderSelfcareAbilityDao;
    }

    public ElderTcmHealthDao getElderTcmHealthDao() {
        return elderTcmHealthDao;
    }

    public ElderTcmLedgerDao getElderTcmLedgerDao() {
        return elderTcmLedgerDao;
    }

    public AgencyPersonDao getAgencyPersonDao() {
        return agencyPersonDao;
    }

    public MemberMovedLogDao getMemberMovedLogDao() {
        return memberMovedLogDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public PersonAddressDao getPersonAddressDao() {
        return personAddressDao;
    }

    public PersonCredentialDao getPersonCredentialDao() {
        return personCredentialDao;
    }

    public PersonDeathDao getPersonDeathDao() {
        return personDeathDao;
    }

    public PersonDiseaseDao getPersonDiseaseDao() {
        return personDiseaseDao;
    }

    public PersonInfoDao getPersonInfoDao() {
        return personInfoDao;
    }

    public PersonPastHistoryDao getPersonPastHistoryDao() {
        return personPastHistoryDao;
    }

    public PersonSerialNoDao getPersonSerialNoDao() {
        return personSerialNoDao;
    }

    public PersonServiceCatalogDao getPersonServiceCatalogDao() {
        return personServiceCatalogDao;
    }

    public RecordChoiceDao getRecordChoiceDao() {
        return recordChoiceDao;
    }

    public SickChoiceMedicineDao getSickChoiceMedicineDao() {
        return sickChoiceMedicineDao;
    }

    public SickMedicineDao getSickMedicineDao() {
        return sickMedicineDao;
    }

    public SmiFollowupDao getSmiFollowupDao() {
        return smiFollowupDao;
    }

    public SmiFollowupDrugDao getSmiFollowupDrugDao() {
        return smiFollowupDrugDao;
    }

    public SmiInfoDao getSmiInfoDao() {
        return smiInfoDao;
    }

    public TermDao getTermDao() {
        return termDao;
    }

    public TuberculosisFirstFollowupDao getTuberculosisFirstFollowupDao() {
        return tuberculosisFirstFollowupDao;
    }

    public TuberculosisFollowupDao getTuberculosisFollowupDao() {
        return tuberculosisFollowupDao;
    }

    public TuberculosisInfoDao getTuberculosisInfoDao() {
        return tuberculosisInfoDao;
    }

    public TuberculosisReferralDao getTuberculosisReferralDao() {
        return tuberculosisReferralDao;
    }

    public UpdateStateDao getUpdateStateDao() {
        return updateStateDao;
    }

    public CdcVaccreportDao getCdcVaccreportDao() {
        return cdcVaccreportDao;
    }

    public CdcVaccreportAdverseDao getCdcVaccreportAdverseDao() {
        return cdcVaccreportAdverseDao;
    }

    public CdcVaccreportVaccinateDao getCdcVaccreportVaccinateDao() {
        return cdcVaccreportVaccinateDao;
    }

    public OrgChoiceVaccineDao getOrgChoiceVaccineDao() {
        return orgChoiceVaccineDao;
    }

    public VaccineDao getVaccineDao() {
        return vaccineDao;
    }

    public VaccineBatchnoDao getVaccineBatchnoDao() {
        return vaccineBatchnoDao;
    }

    public VaccineInjectTimesDao getVaccineInjectTimesDao() {
        return vaccineInjectTimesDao;
    }

    public VaccineManufacturerDao getVaccineManufacturerDao() {
        return vaccineManufacturerDao;
    }

    public VisitDetailDao getVisitDetailDao() {
        return visitDetailDao;
    }

    public VisitMedicineDao getVisitMedicineDao() {
        return visitMedicineDao;
    }

    public SessionRspDao getSessionRspDao() {
        return sessionRspDao;
    }

}
