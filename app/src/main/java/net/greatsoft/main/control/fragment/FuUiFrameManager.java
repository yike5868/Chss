package net.greatsoft.main.control.fragment;


import android.content.Context;

import net.greatsoft.main.control.FuEventCallBack;
import net.greatsoft.main.uiframe.FuCdcHasView;
import net.greatsoft.main.uiframe.FuCdcNoView;
import net.greatsoft.main.uiframe.FuCdcVaccreportView;
import net.greatsoft.main.uiframe.FuCerebralApoplexyView;
import net.greatsoft.main.uiframe.FuCerebralInfoView;
import net.greatsoft.main.uiframe.FuChangeView;
import net.greatsoft.main.uiframe.FuChildHealthExam02View;
import net.greatsoft.main.uiframe.FuChildHealthExam03View;
import net.greatsoft.main.uiframe.FuChildHealthExam04View;
import net.greatsoft.main.uiframe.FuChildHomeVisitView;
import net.greatsoft.main.uiframe.FuChildInfoView;
import net.greatsoft.main.uiframe.FuChildTcmLedgerView;
import net.greatsoft.main.uiframe.FuCognitionView;
import net.greatsoft.main.uiframe.FuCoronaryHeartInfoView;
import net.greatsoft.main.uiframe.FuCoronaryHeartView;
import net.greatsoft.main.uiframe.FuDepressedView;
import net.greatsoft.main.uiframe.FuDiaChartView;
import net.greatsoft.main.uiframe.FuDiaHY01View;
import net.greatsoft.main.uiframe.FuDiaHY02View;
import net.greatsoft.main.uiframe.FuDiaHY03View;
import net.greatsoft.main.uiframe.FuDiaHY04View;
import net.greatsoft.main.uiframe.FuDiabetesInfoView;
import net.greatsoft.main.uiframe.FuDiabetesView;
import net.greatsoft.main.uiframe.FuDisabilityHearView;
import net.greatsoft.main.uiframe.FuDisabilityIntelligenceView;
import net.greatsoft.main.uiframe.FuDisabilityLimbView;
import net.greatsoft.main.uiframe.FuDisabilityVisualView;
import net.greatsoft.main.uiframe.FuDownView;
import net.greatsoft.main.uiframe.FuElderInfoView;
import net.greatsoft.main.uiframe.FuElderTcmHealthView;
import net.greatsoft.main.uiframe.FuExam01View;
import net.greatsoft.main.uiframe.FuExam02View;
import net.greatsoft.main.uiframe.FuExam03View;
import net.greatsoft.main.uiframe.FuExam04View;
import net.greatsoft.main.uiframe.FuFamilyAdd01View;
import net.greatsoft.main.uiframe.FuFamilyAdd02View;
import net.greatsoft.main.uiframe.FuFamilyAdd03View;
import net.greatsoft.main.uiframe.FuFamilyAddView;
import net.greatsoft.main.uiframe.FuFamilyMemberView;
import net.greatsoft.main.uiframe.FuGPFollowView;
import net.greatsoft.main.uiframe.FuGPMainView;
import net.greatsoft.main.uiframe.FuGPStatisticsView;
import net.greatsoft.main.uiframe.FuGuideView;
import net.greatsoft.main.uiframe.FuHasDownView;
import net.greatsoft.main.uiframe.FuHomeView;
import net.greatsoft.main.uiframe.FuHyperChartView;
import net.greatsoft.main.uiframe.FuHyperInfoView;
import net.greatsoft.main.uiframe.FuHyperView;
import net.greatsoft.main.uiframe.FuListView;
import net.greatsoft.main.uiframe.FuLoginView;
import net.greatsoft.main.uiframe.FuMaternalFirstFollowupView;
import net.greatsoft.main.uiframe.FuMaternalFollowupView;
import net.greatsoft.main.uiframe.FuMaternalPostpartumFollowupView;
import net.greatsoft.main.uiframe.FuMaternalRegisterView;
import net.greatsoft.main.uiframe.FuMemberAdd01View;
import net.greatsoft.main.uiframe.FuMemberAdd02View;
import net.greatsoft.main.uiframe.FuMemberAdd03View;
import net.greatsoft.main.uiframe.FuMemberAdd04View;
import net.greatsoft.main.uiframe.FuMemberAddView;
import net.greatsoft.main.uiframe.FuModifyPersonalInfomationView;
import net.greatsoft.main.uiframe.FuPatientInfoView;
import net.greatsoft.main.uiframe.FuPersonHistoryView;
import net.greatsoft.main.uiframe.FuRecordsView;
import net.greatsoft.main.uiframe.FuRegistView;
import net.greatsoft.main.uiframe.FuSExamView;
import net.greatsoft.main.uiframe.FuSFamilyView;
import net.greatsoft.main.uiframe.FuSLgtView;
import net.greatsoft.main.uiframe.FuSPersonInfoView;
import net.greatsoft.main.uiframe.FuSRhsfView;
import net.greatsoft.main.uiframe.FuSSetView;
import net.greatsoft.main.uiframe.FuSSlView;
import net.greatsoft.main.uiframe.FuSUploadView;
import net.greatsoft.main.uiframe.FuSYzView;
import net.greatsoft.main.uiframe.FuSearchPersonView;
import net.greatsoft.main.uiframe.FuSearchView;
import net.greatsoft.main.uiframe.FuSelfcareView;
import net.greatsoft.main.uiframe.FuSetPasswordView;
import net.greatsoft.main.uiframe.FuSetView;
import net.greatsoft.main.uiframe.FuSmiInfoView;
import net.greatsoft.main.uiframe.FuSmiView;
import net.greatsoft.main.uiframe.FuTuberculosisFirstFollowupView;
import net.greatsoft.main.uiframe.FuTuberculosisFollowupView;
import net.greatsoft.main.uiframe.FuTuberculosisInfoView;
import net.greatsoft.main.uiframe.FuUiFrameModel;
import net.greatsoft.main.uiframe.FuWebView;
import net.greatsoft.main.uiframe.FuWelcomeView;
import net.greatsoft.main.uiframe.FuYzBloodView;
import net.greatsoft.main.uiframe.FuYzList_View;
import net.greatsoft.main.uiframe.FuYzSugarView;
import net.greatsoft.main.uiframe.ReadCardView;

public class FuUiFrameManager {

    public static final int FU_MAIN_ID = 999; // MainActivity 视图ID
    public static final int FU_CONTENT_ID = 998; // ContentActivity 视图ID
    public static final int FU_CHANGE_ID = 997;//ChangeActivity 视图ID
    public static final int FU_RHSF_ID = 996;// 入户随访视图ID
    public static final int FU_EXAM_ID = 995;// 入户随访视图ID

    public static final int FU_ERROR = -1; // 没有创建
    public static final int FU_LOGIN = 2; // 登录
    public static final int FU_REGIST = 3; // 注册
    public static final int FU_MAIN_HOME = 5; // 首页
    public static final int FU_SET = 6; // 设置
    public static final int FU_SET_PASSWORD = 7; // 修改密码
    public static final int FU_WEBVIEW = 41; // 网页内容查看
    public static final int FU_WELCOME = 42; // 欢迎界面
    public static final int FU_GUIDE = 43; // 向导界面
    public static final int FU_DOWN = 44; //下载页面
    public static final int FU_HAS_DOWN = 45;//已下载页面

    public static final int FU_S_RHSF = 21;//入户随访
    public static final int FU_S_LGT = 22;//老高糖
    public static final int FU_S_EXAM = 23;//体检
    public static final int FU_S_MEMBER = 24;//人员
    public static final int FU_S_YZ = 25;//义诊
    public static final int FU_S_SL = 26;//失联
    public static final int FU_S_UPLOAD = 27;//上传
    public static final int FU_S_SET = 28;//设置
    public static final int FU_S_FAMILY = 29;//家庭


    public static final int FU_PATIENT_INFO = 30; //入户随访
    public static final int FU_DY_01 = 31;//入户随访01
    public static final int FU_DY_02 = 32;//入户随访02
    public static final int FU_DY_03 = 33;//入户随访03
    public static final int FU_DY_04 = 34;//入户随访04
    public static final int FU_MODIFY_PERSONAL = 35;// 修改个人信息
    public static final int FU_FAMILY_MEMBER = 60;//家庭成员
    public static final int FU_PERSON_HISTORY = 100;//入户随访个人历史记录
    public static final int FU_MEMBERADD_01 = 101;//入户随访-新增家庭成员-个人信息
    public static final int FU_MEMBERADD_02 = 102;//入户随访-新增家庭成员-户籍信息
    public static final int FU_MEMBERADD_03 = 103;//入户随访-新增家庭成员-医疗费用支付
    public static final int FU_MEMBERADD_04 = 104;//入户随访-新增家庭成员-药物过敏史

    public static final int FU_EXAM_01 = 36;    //体检01
    public static final int FU_EXAM_02 = 37;    //体检02
    public static final int FU_EXAM_03 = 38;    //体检03
    public static final int FU_EXAM_04 = 39;    //体检04

    public static final int FU_YZ_BLOOD = 51;    //义诊 血压
    public static final int FU_YZ_SUGAR = 52;    //义诊 血糖
    public static final int FU_YZ_LIST = 55;    //义诊


    public static final int FU_FAMILY_ADD = 53;//新增家庭
    public static final int FU_MEMBER_ADD = 54;//新增人员
    public static final int FU_FAMILY_01_ADD = 69;
    public static final int FU_FAMILY_02_ADD = 70;
    public static final int FU_FAMILY_03_ADD = 71;


    public static final int FU_SEARCH_PERSON = 61;//搜索人员

    public static final int FU_DIA_CHART = 63;// 血糖图
    public static final int FU_HYPER_CHART = 64;//血压图
    public static final int FU_RECORDS = 65;//医诊
    public static final int FU_GP_MAIN = 66;//全科医生

    public static final int FU_GP_FOLLOW = 67;// 全科医生 随访
    public static final int FU_GP_STATISTICS = 68;//全科医生 统计

    public static final int FU_LIST_VIEW = 81;// 所有二级页面

    public static final int FU_HYPER = 90;//高血压 随访
    public static final int FU_DIABETES = 91; //糖尿病随访
    public static final int FU_SMI = 93;  //精神病随访
    public static final int FU_SMI_INFO = 97;  //精神病个人信息
    public static final int FU_SELFCARE = 94;//老年人自理能力
    public static final int FU_COGNITION = 95;    //老年人认知功能
    public static final int FU_DEPRESSED = 96;    //老年人抑郁
    public static final int FU_ELDER_TCM = 119;//老年人中医药管理

    public static final int FU_CHILD_HEALTH_EXAM_02 = 106; //1-8月
    public static final int FU_CHILD_HEALTH_EXAM_03 = 107; //12-30月
    public static final int FU_CHILD_HEALTH_EXAM_04 = 108; //3-6岁

    public static final int FU_CHILD_HOME_VISIT = 109; //新生儿家庭访视

    public static final int FU_SEARCH = 111;// 搜索


    public static final int FU_MATERNAL_CHILD_BIRTH = 112;//分娩登记
    public static final int FU_MATERNAL_NEW_BORN_SITUATION = 113;//分娩登记-新生儿记录情况
    public static final int FU_MATERNAL_REGISTER = 114;//孕产登记

    public static final int FU_MATERNAL_FIRST_FOLLOW_UP = 115;//孕产妇第一次产前随访
    public static final int FU_MATERNAL_FOLLOW_UP = 116;//孕产妇非首次产前随访
    public static final int FU_MATERNAL_POST_PARTUM_FOLLOW_UP = 117;//产后访视记录表


    public static final int FU_TUBERCULOSIS_FIRST_FOLLOWUP = 120;//肺结核患者第一次入户随访

    public static final int FU_TUBERCULOSIS_FOLLOWUP = 121;//肺结核患者随访

    public static final int FU_CORONARYHEART_FOLLOWUP = 128;//冠心病患者随访
    public static final int FU_CEREBRALAPOPLEXY_FOLLOWUP = 129;//脑卒中患者随访


    public static final int FU_CDCVACC_REPORT = 123;//预防接种卡
    public static final int FU_CDCVACCREPORT_VACCINATE = 124;//预防接种记录

    public static final int FU_CHILD_TCM_LEDGER = 122;//儿童中医药管理

    public static final int FU_CHANGE = 125;//切换页面

    public static final int FU_CDC_HAS = 126;//已接种
    public static final int FU_CDC_NO = 127;//未接种


    public static final int FU_HYPER_INFO = 130 ;//高血压专档
    public static final int FU_DISABILITY_HEAR = 137 ;//听力言语残疾
    public static final int FU_DISABILITY_INTELLIGENCE = 138 ;//智力残疾
    public static final int FU_DISABILITY_LIMB = 139 ;//肢体残疾
    public static final int FU_DISABILITY_VISUAL = 140 ;//视力残疾

    public static final int FU_DIABETES_INFO = 131;//糖尿病专档

    public static final int FU_ELDERINFO = 132;//老年人专档
    public static final int FU_CONARANYHEART_INFO = 133 ;//冠心病专档
    public static final int FU_CEREBRAL_INFO = 134 ;//脑卒中专档
    public static final int FU_CHILD_INFO = 136 ;//儿童专档
    public static final int FU_TUBERCULOSIS_INFO = 135 ;//脑卒中专档
    public static final int FU_READ_CARD = 150;//读卡



    public FuUiFrameModel createFuModel(int type, Context contex,
                                        FuEventCallBack callBack) {

        switch (type) {

            case FU_WEBVIEW:
                return new FuWebView(contex, callBack);
            case FU_LOGIN:
                return new FuLoginView(contex, callBack);
            case FU_REGIST:
                return new FuRegistView(contex, callBack);
            case FU_MAIN_HOME:
                return new FuHomeView(contex, callBack);
            case FU_SET:
                return new FuSetView(contex, callBack);
            case FU_SET_PASSWORD:
                return new FuSetPasswordView(contex, callBack);
            case FU_WELCOME:
                return new FuWelcomeView(contex, callBack);
            case FU_GUIDE:
                return new FuGuideView(contex, callBack);
            case FU_DOWN:
                return new FuDownView(contex, callBack);
            case FU_HAS_DOWN:
                return new FuHasDownView(contex, callBack);
            case FU_S_RHSF:
                return new FuSRhsfView(contex, callBack);
            case FU_S_LGT:
                return new FuSLgtView(contex, callBack);
            case FU_S_EXAM:
                return new FuSExamView(contex, callBack);
            case FU_S_MEMBER:
                return new FuSPersonInfoView(contex, callBack);
            case FU_YZ_LIST:
                return new FuYzList_View(contex, callBack);
            case FU_S_SL:
                return new FuSSlView(contex, callBack);
            case FU_S_UPLOAD:
                return new FuSUploadView(contex, callBack);
            case FU_S_SET:
                return new FuSSetView(contex, callBack);
            case FU_DY_01:
                return new FuDiaHY01View(contex, callBack);
            case FU_DY_02:
                return new FuDiaHY02View(contex, callBack);
            case FU_DY_03:
                return new FuDiaHY03View(contex, callBack);
            case FU_DY_04:
                return new FuDiaHY04View(contex, callBack);
            case FU_PATIENT_INFO:
                return new FuPatientInfoView(contex, callBack);
            case FU_MODIFY_PERSONAL:
                return new FuModifyPersonalInfomationView(contex, callBack);
            case FU_EXAM_01:
                return new FuExam01View(contex, callBack);
            case FU_EXAM_02:
                return new FuExam02View(contex, callBack);
            case FU_EXAM_03:
                return new FuExam03View(contex, callBack);
            case FU_EXAM_04:
                return new FuExam04View(contex, callBack);
            case FU_YZ_BLOOD:
                return new FuYzBloodView(contex, callBack);
            case FU_YZ_SUGAR:
                return new FuYzSugarView(contex, callBack);
            case FU_S_YZ:
                return new FuSYzView(contex, callBack);
            case FU_FAMILY_ADD:
                return new FuFamilyAddView(contex, callBack);
            case FU_MEMBER_ADD:
                return new FuMemberAddView(contex, callBack);
            case FU_SEARCH_PERSON:
                return new FuSearchPersonView(contex, callBack);
            case FU_S_FAMILY:
                return new FuSFamilyView(contex, callBack);
            case FU_FAMILY_MEMBER:
                return new FuFamilyMemberView(contex, callBack);
            case FU_DIA_CHART:
                return new FuDiaChartView(contex, callBack);
            case FU_HYPER_CHART:
                return new FuHyperChartView(contex, callBack);
            case FU_RECORDS:
                return new FuRecordsView(contex, callBack);
            case FU_GP_MAIN:
                return new FuGPMainView(contex, callBack);
            case FU_GP_FOLLOW:
                return new FuGPFollowView(contex, callBack);
            case FU_GP_STATISTICS:
                return new FuGPStatisticsView(contex, callBack);
            case FU_FAMILY_01_ADD:
                return new FuFamilyAdd01View(contex, callBack);
            case FU_FAMILY_02_ADD:
                return new FuFamilyAdd02View(contex, callBack);
            case FU_FAMILY_03_ADD:
                return new FuFamilyAdd03View(contex, callBack);
            case FU_PERSON_HISTORY:
                return new FuPersonHistoryView(contex, callBack);
            case FU_MEMBERADD_01:
                return new FuMemberAdd01View(contex, callBack);
            case FU_MEMBERADD_02:
                return new FuMemberAdd02View(contex, callBack);
            case FU_MEMBERADD_03:
                return new FuMemberAdd03View(contex, callBack);
            case FU_MEMBERADD_04:
                return new FuMemberAdd04View(contex, callBack);
            case FU_LIST_VIEW:
                return new FuListView(contex, callBack);

            case FU_HYPER:
                return new FuHyperView(contex, callBack);
            case FU_DIABETES:
                return new FuDiabetesView(contex, callBack);
            case FU_SMI:
                return new FuSmiView(contex, callBack);
            case FU_SMI_INFO:
                return new FuSmiInfoView(contex, callBack);
            case FU_SELFCARE:
                return new FuSelfcareView(contex, callBack);
            case FU_COGNITION:
                return new FuCognitionView(contex, callBack);
            case FU_DEPRESSED:
                return new FuDepressedView(contex, callBack);

            case FU_SEARCH:
                return new FuSearchView(contex, callBack);


            case FU_CHILD_HEALTH_EXAM_02:
                return new FuChildHealthExam02View(contex, callBack);
            case FU_CHILD_HEALTH_EXAM_03:
                return new FuChildHealthExam03View(contex, callBack);
            case FU_CHILD_HEALTH_EXAM_04:
                return new FuChildHealthExam04View(contex, callBack);
            case FU_CHILD_HOME_VISIT:
                return new FuChildHomeVisitView(contex, callBack);


            case FU_MATERNAL_FIRST_FOLLOW_UP:
                return new FuMaternalFirstFollowupView(contex, callBack);
            case FU_MATERNAL_FOLLOW_UP:
                return new FuMaternalFollowupView(contex, callBack);
            case FU_MATERNAL_POST_PARTUM_FOLLOW_UP:
                return new FuMaternalPostpartumFollowupView(contex, callBack);

            case FU_ELDER_TCM:
                return new FuElderTcmHealthView(contex,callBack);

            case FU_TUBERCULOSIS_FIRST_FOLLOWUP:
                return new FuTuberculosisFirstFollowupView(contex,callBack);
            case FU_TUBERCULOSIS_FOLLOWUP:
                return new FuTuberculosisFollowupView(contex,callBack);
            case FU_CORONARYHEART_FOLLOWUP:
                return new FuCoronaryHeartView(contex, callBack);
            case FU_CEREBRALAPOPLEXY_FOLLOWUP:
                return new FuCerebralApoplexyView(contex, callBack);
            case FU_CHILD_TCM_LEDGER:
                return new FuChildTcmLedgerView(contex,callBack);

            case FU_CDCVACC_REPORT:
                return new FuCdcVaccreportView(contex,callBack);

            case FU_CHANGE:
                return new FuChangeView(contex,callBack);

            case FU_CDC_HAS:
                return new FuCdcHasView(contex,callBack);
            case FU_CDC_NO:
                return new FuCdcNoView(contex,callBack);
            case FU_HYPER_INFO:
                return new FuHyperInfoView(contex,callBack);
            case FU_DIABETES_INFO:
                return new FuDiabetesInfoView(contex,callBack);
            case FU_CONARANYHEART_INFO:
                return new FuCoronaryHeartInfoView(contex,callBack);
            case FU_CEREBRAL_INFO:
                return new FuCerebralInfoView(contex,callBack);
            case FU_CHILD_INFO:
                return new FuChildInfoView(contex,callBack);
            case FU_ELDERINFO:
                return new FuElderInfoView(contex,callBack);
            case FU_TUBERCULOSIS_INFO:
                return new FuTuberculosisInfoView(contex,callBack);
            case FU_MATERNAL_REGISTER:
                return new FuMaternalRegisterView(contex,callBack);
            case FU_DISABILITY_HEAR:
                return new FuDisabilityHearView(contex,callBack);
            case FU_DISABILITY_INTELLIGENCE:
                return new FuDisabilityIntelligenceView(contex,callBack);
            case FU_DISABILITY_LIMB:
                return new FuDisabilityLimbView(contex,callBack);
            case FU_DISABILITY_VISUAL:
                return new FuDisabilityVisualView(contex,callBack);
            case FU_READ_CARD:
                return new ReadCardView(contex,callBack);
        }

        return null;
    }
}
