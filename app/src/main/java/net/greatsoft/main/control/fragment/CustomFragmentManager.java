package net.greatsoft.main.control.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import net.greatsoft.main.FuApp;
import net.greatsoft.main.FuFmArray;
import net.greatsoft.main.control.ActionFragment;
import net.greatsoft.main.fragment.FuCdcHasFragment;
import net.greatsoft.main.fragment.FuCdcNoFragment;
import net.greatsoft.main.fragment.FuCdcVaccreportFragment;
import net.greatsoft.main.fragment.FuCerebralApoplexyFragment;
import net.greatsoft.main.fragment.FuCerebralInfoFragment;
import net.greatsoft.main.fragment.FuChangeFragment;
import net.greatsoft.main.fragment.FuChildHealthExam02Fragment;
import net.greatsoft.main.fragment.FuChildHealthExam03Fragment;
import net.greatsoft.main.fragment.FuChildHealthExam04Fragment;
import net.greatsoft.main.fragment.FuChildHomeVisitFragment;
import net.greatsoft.main.fragment.FuChildInfoFragment;
import net.greatsoft.main.fragment.FuChildTcmLedgerFragment;
import net.greatsoft.main.fragment.FuCognitionFragment;
import net.greatsoft.main.fragment.FuCoronaryHeartInfoFragment;
import net.greatsoft.main.fragment.FuDepressedFragment;
import net.greatsoft.main.fragment.FuDiaChartFragment;
import net.greatsoft.main.fragment.FuDiaHY01Fragment;
import net.greatsoft.main.fragment.FuDiaHY02Fragment;
import net.greatsoft.main.fragment.FuDiaHY03Fragment;
import net.greatsoft.main.fragment.FuDiaHY04Fragment;
import net.greatsoft.main.fragment.FuDiabetesFragment;
import net.greatsoft.main.fragment.FuDiabetesInfoFragment;
import net.greatsoft.main.fragment.FuDisabilityHearFragment;
import net.greatsoft.main.fragment.FuDisabilityIntelligenceFragment;
import net.greatsoft.main.fragment.FuDisabilityLimbFragment;
import net.greatsoft.main.fragment.FuDisabilityVisualFragment;
import net.greatsoft.main.fragment.FuDownFragment;
import net.greatsoft.main.fragment.FuElderInfoFragment;
import net.greatsoft.main.fragment.FuElderTcmHealthFragment;
import net.greatsoft.main.fragment.FuExam01Fragment;
import net.greatsoft.main.fragment.FuExam02Fragment;
import net.greatsoft.main.fragment.FuExam03Fragment;
import net.greatsoft.main.fragment.FuExam04Fragment;
import net.greatsoft.main.fragment.FuFamilyAdd01Fragment;
import net.greatsoft.main.fragment.FuFamilyAdd02Fragment;
import net.greatsoft.main.fragment.FuFamilyAdd03Fragment;
import net.greatsoft.main.fragment.FuFamilyAddFragment;
import net.greatsoft.main.fragment.FuFamilyMemberFragment;
import net.greatsoft.main.fragment.FuGPFollowFragment;
import net.greatsoft.main.fragment.FuGPMainFragment;
import net.greatsoft.main.fragment.FuGPStattisticsFragment;
import net.greatsoft.main.fragment.FuGuideFragment;
import net.greatsoft.main.fragment.FuHasDownFragment;
import net.greatsoft.main.fragment.FuHomeFragment;
import net.greatsoft.main.fragment.FuHyperChartFragment;
import net.greatsoft.main.fragment.FuHyperFragment;
import net.greatsoft.main.fragment.FuHyperInfoFragment;
import net.greatsoft.main.fragment.FuListFragment;
import net.greatsoft.main.fragment.FuLoginFragment;
import net.greatsoft.main.fragment.FuMaternalFirstFollowupFragment;
import net.greatsoft.main.fragment.FuMaternalFollowupFragment;
import net.greatsoft.main.fragment.FuMaternalPostpartumFollowupFragment;
import net.greatsoft.main.fragment.FuMaternalRegisterFragment;
import net.greatsoft.main.fragment.FuMemberAdd01Fragment;
import net.greatsoft.main.fragment.FuMemberAdd02Fragment;
import net.greatsoft.main.fragment.FuMemberAdd03Fragment;
import net.greatsoft.main.fragment.FuMemberAdd04Fragment;
import net.greatsoft.main.fragment.FuMemberAddFragment;
import net.greatsoft.main.fragment.FuModifyPersonalInfomationFragment;
import net.greatsoft.main.fragment.FuPatientInfoFragment;
import net.greatsoft.main.fragment.FuPersonHistoryFragment;
import net.greatsoft.main.fragment.FuRecordsFragment;
import net.greatsoft.main.fragment.FuRegistFragment;
import net.greatsoft.main.fragment.FuSExamFragment;
import net.greatsoft.main.fragment.FuSFamilyFragment;
import net.greatsoft.main.fragment.FuSLgtFragment;
import net.greatsoft.main.fragment.FuSPersonInfoFragment;
import net.greatsoft.main.fragment.FuSRhsfFragment;
import net.greatsoft.main.fragment.FuSSetFragment;
import net.greatsoft.main.fragment.FuSSlFragment;
import net.greatsoft.main.fragment.FuSUploadFragment;
import net.greatsoft.main.fragment.FuSYzFragment;
import net.greatsoft.main.fragment.FuSearchFragment;
import net.greatsoft.main.fragment.FuSearchPersonFragment;
import net.greatsoft.main.fragment.FuSelfcareFragment;
import net.greatsoft.main.fragment.FuSetFragment;
import net.greatsoft.main.fragment.FuSetPasswordFragment;
import net.greatsoft.main.fragment.FuSmiFragment;
import net.greatsoft.main.fragment.FuSmiInfoFragment;
import net.greatsoft.main.fragment.FuTuberculosisFirstFollowupFragment;
import net.greatsoft.main.fragment.FuTuberculosisFollowupFragment;
import net.greatsoft.main.fragment.FuTuberculosisInfoFragment;
import net.greatsoft.main.fragment.FuWebViewFragment;
import net.greatsoft.main.fragment.FuWelcomeFragment;
import net.greatsoft.main.fragment.FuYzBloodFragment;
import net.greatsoft.main.fragment.FuYzListFragment;
import net.greatsoft.main.fragment.FuYzSugarFragment;
import net.greatsoft.main.fragment.FucoronaryHeartFragment;
import net.greatsoft.main.fragment.ReadCardFragment;

/**
 *
 *
 */
public class CustomFragmentManager {

    public static final int INIT_NAV = 0;

    public static final int LOGIN_REGIST = 1;

    public static final int MAIN = 2;

    public static final int CONTENT = 3;


    private FragmentManager mManager;

    private FuFmArray[] mFuFmArray;

    public static CustomFragmentManager getInstance(Context context) {

        FuApp app = (FuApp) ((Activity) context).getApplication();

        return app.getFragmentManager();
    }

    private int mCurrentNameId;

    public void initFragmentManager(int nameId, FragmentManager manager) {

        mManager = manager;

        mCurrentNameId = nameId;
    }

    public void ExitFreeResource() {

        mFuFmArray = null;
    }

    /**
     * @param fragementID
     * @param action
     */
    public void addFragment(int fragementID, int action) {

        if (mManager == null) {
            throw new IllegalStateException("Please init FragmentManager");
        }

        Log.i("action---", "==" + action);

        Fragment lCurentFragment = createFragment(action, null);

        if (lCurentFragment == null) {
            return;
        }

        ActionFragment lActionObj = new ActionFragment();
        lActionObj.setmEventAction(action);
        lActionObj.setmFragment(lCurentFragment);
        addFragment(lActionObj);

        mCurrentAction = action;

        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(fragementID, lCurentFragment);
        transaction.commit();
    }

    private Fragment createNewFragment(int action, Bundle bundle) {

        switch (action) {

            case FuUiFrameManager.FU_WEBVIEW:
                FuWebViewFragment lGhWebXq = new FuWebViewFragment();
                lGhWebXq.intentData(bundle);
                return lGhWebXq;
            case FuUiFrameManager.FU_MAIN_HOME:
                return new FuHomeFragment();
            case FuUiFrameManager.FU_LOGIN:
                return new FuLoginFragment();
            case FuUiFrameManager.FU_REGIST:
                return new FuRegistFragment();
            case FuUiFrameManager.FU_GUIDE:
                FuGuideFragment lGuideFragment = new FuGuideFragment();
                lGuideFragment.intentData(bundle);
                return lGuideFragment;
            case FuUiFrameManager.FU_WELCOME:
                return new FuWelcomeFragment();
            case FuUiFrameManager.FU_DOWN:
                return new FuDownFragment();
            case FuUiFrameManager.FU_HAS_DOWN:
                return new FuHasDownFragment();
            case FuUiFrameManager.FU_S_RHSF:
                return new FuSRhsfFragment();
            case FuUiFrameManager.FU_S_LGT:
                return new FuSLgtFragment();
            case FuUiFrameManager.FU_S_EXAM:
                return new FuSExamFragment();
            case FuUiFrameManager.FU_S_MEMBER:
                return new FuSPersonInfoFragment();
            case FuUiFrameManager.FU_YZ_LIST:
                return new FuYzListFragment();
            case FuUiFrameManager.FU_S_SL:
                return new FuSSlFragment();
            case FuUiFrameManager.FU_S_UPLOAD:
                return new FuSUploadFragment();
            case FuUiFrameManager.FU_S_SET:
                return new FuSSetFragment();
            case FuUiFrameManager.FU_DY_01:
                return new FuDiaHY01Fragment();
            case FuUiFrameManager.FU_DY_02:
                return new FuDiaHY02Fragment();
            case FuUiFrameManager.FU_DY_03:
                return new FuDiaHY03Fragment();
            case FuUiFrameManager.FU_DY_04:
                return new FuDiaHY04Fragment();
            case FuUiFrameManager.FU_PATIENT_INFO:
                FuPatientInfoFragment fuPatientInfoFragment = new FuPatientInfoFragment();
                fuPatientInfoFragment.intentData(bundle);
                return fuPatientInfoFragment;
            case FuUiFrameManager.FU_MODIFY_PERSONAL:
                return new FuModifyPersonalInfomationFragment();
            case FuUiFrameManager.FU_EXAM_01:
                return new FuExam01Fragment();
            case FuUiFrameManager.FU_EXAM_02:
                return new FuExam02Fragment();
            case FuUiFrameManager.FU_EXAM_03:
                return new FuExam03Fragment();
            case FuUiFrameManager.FU_EXAM_04:
                return new FuExam04Fragment();
            case FuUiFrameManager.FU_S_YZ:
                return new FuSYzFragment();
            case FuUiFrameManager.FU_YZ_BLOOD:
                return new FuYzBloodFragment();
            case FuUiFrameManager.FU_YZ_SUGAR:
                return new FuYzSugarFragment();
            case FuUiFrameManager.FU_FAMILY_ADD:
                FuFamilyAddFragment fuFamilyAddFragment = new FuFamilyAddFragment();
                fuFamilyAddFragment.intentData(bundle);
                return fuFamilyAddFragment;
            case FuUiFrameManager.FU_MEMBER_ADD:

                FuMemberAddFragment fuMemberAddFragment = new FuMemberAddFragment();
                fuMemberAddFragment.intentData(bundle);
                return fuMemberAddFragment;
            case FuUiFrameManager.FU_SEARCH_PERSON:
                return new FuSearchPersonFragment();
            case FuUiFrameManager.FU_S_FAMILY:
                FuSFamilyFragment fuSFamilyFragment = new FuSFamilyFragment();
                return fuSFamilyFragment;
            case FuUiFrameManager.FU_FAMILY_MEMBER:
                FuFamilyMemberFragment fuFamilyMemberFragment = new FuFamilyMemberFragment();
                fuFamilyMemberFragment.intentData(bundle);
                return fuFamilyMemberFragment;


            case FuUiFrameManager.FU_DIA_CHART:

                FuDiaChartFragment fuDiaChartFragment = new FuDiaChartFragment();
                fuDiaChartFragment.initData(bundle);
                return fuDiaChartFragment;
            case FuUiFrameManager.FU_HYPER_CHART:
                return new FuHyperChartFragment();
            case FuUiFrameManager.FU_RECORDS:
                return new FuRecordsFragment();
            case FuUiFrameManager.FU_GP_MAIN:
                return new FuGPMainFragment();
            case FuUiFrameManager.FU_GP_FOLLOW:
                return new FuGPFollowFragment();
            case FuUiFrameManager.FU_GP_STATISTICS:
                return new FuGPStattisticsFragment();
            case FuUiFrameManager.FU_FAMILY_01_ADD:
                return new FuFamilyAdd01Fragment();
            case FuUiFrameManager.FU_FAMILY_02_ADD:
                return new FuFamilyAdd02Fragment();
            case FuUiFrameManager.FU_FAMILY_03_ADD:
                return new FuFamilyAdd03Fragment();
            case FuUiFrameManager.FU_PERSON_HISTORY:
                return new FuPersonHistoryFragment();
            case FuUiFrameManager.FU_MEMBERADD_01:
                return new FuMemberAdd01Fragment();
            case FuUiFrameManager.FU_MEMBERADD_02:
                return new FuMemberAdd02Fragment();
            case FuUiFrameManager.FU_MEMBERADD_03:
                return new FuMemberAdd03Fragment();
            case FuUiFrameManager.FU_MEMBERADD_04:
                return new FuMemberAdd04Fragment();
            case FuUiFrameManager.FU_LIST_VIEW:
                FuListFragment fuListFragment = new FuListFragment();
//                fuListFragment.initData(bundle);
                return fuListFragment;
            case FuUiFrameManager.FU_HYPER:
                FuHyperFragment fuHyperFragment = new FuHyperFragment();
                fuHyperFragment.initData(bundle);
                return fuHyperFragment;
            case FuUiFrameManager.FU_DIABETES:
                FuDiabetesFragment fuDiabetesFragment = new FuDiabetesFragment();
                fuDiabetesFragment.initData(bundle);
                return fuDiabetesFragment;
            case FuUiFrameManager.FU_SMI:
                FuSmiFragment fuSmiFragment = new FuSmiFragment();
                fuSmiFragment.initData(bundle);
                return fuSmiFragment;
            case FuUiFrameManager.FU_SMI_INFO:
                FuSmiInfoFragment fuSmiInfoFragment = new FuSmiInfoFragment();
                fuSmiInfoFragment.initData(bundle);
                return fuSmiInfoFragment;
            case FuUiFrameManager.FU_SELFCARE:
                FuSelfcareFragment fuSelfcareFragment = new FuSelfcareFragment();
                fuSelfcareFragment.initData(bundle);
                return fuSelfcareFragment;
            case FuUiFrameManager.FU_COGNITION:
                FuCognitionFragment fuCognitionFragment = new FuCognitionFragment();
                fuCognitionFragment.initData(bundle);
                return fuCognitionFragment;
            case FuUiFrameManager.FU_DEPRESSED:
                FuDepressedFragment fuDepressedFragment = new FuDepressedFragment();
                return fuDepressedFragment;
            case FuUiFrameManager.FU_SEARCH:
                FuSearchFragment fuSearchFragment = new FuSearchFragment();
                fuSearchFragment.initData(bundle);
                return fuSearchFragment;

            case FuUiFrameManager.FU_CHILD_HEALTH_EXAM_02:
                FuChildHealthExam02Fragment fuChildHealthExam02Fragment = new FuChildHealthExam02Fragment();
                fuChildHealthExam02Fragment.initData(bundle);
                return fuChildHealthExam02Fragment;
            case FuUiFrameManager.FU_CHILD_HEALTH_EXAM_03:
                FuChildHealthExam03Fragment fuChildHealthExam03Fragment = new FuChildHealthExam03Fragment();
                fuChildHealthExam03Fragment.initData(bundle);
                return fuChildHealthExam03Fragment;
            case FuUiFrameManager.FU_CHILD_HEALTH_EXAM_04:
                FuChildHealthExam04Fragment fuChildHealthExam04Fragment = new FuChildHealthExam04Fragment();
                fuChildHealthExam04Fragment.initData(bundle);
                return fuChildHealthExam04Fragment;

            case FuUiFrameManager.FU_CHILD_HOME_VISIT:
                FuChildHomeVisitFragment fuChildHomeVisitFragment = new FuChildHomeVisitFragment();
                fuChildHomeVisitFragment.initData(bundle);
                return fuChildHomeVisitFragment;


            case FuUiFrameManager.FU_MATERNAL_FIRST_FOLLOW_UP:
                FuMaternalFirstFollowupFragment fuMaternalFirstFollowupFragment = new FuMaternalFirstFollowupFragment();
                fuMaternalFirstFollowupFragment.initData(bundle);
                return fuMaternalFirstFollowupFragment;

            case FuUiFrameManager.FU_MATERNAL_FOLLOW_UP:
                FuMaternalFollowupFragment fuMaternalFollowupFragment = new FuMaternalFollowupFragment();
                fuMaternalFollowupFragment.initData(bundle);
                return fuMaternalFollowupFragment;


            case FuUiFrameManager.FU_MATERNAL_POST_PARTUM_FOLLOW_UP:
                FuMaternalPostpartumFollowupFragment fuMaternalPostpartumFollowupFragment = new FuMaternalPostpartumFollowupFragment();
                fuMaternalPostpartumFollowupFragment.initData(bundle);
                return fuMaternalPostpartumFollowupFragment;
            case FuUiFrameManager.FU_ELDER_TCM:
                FuElderTcmHealthFragment fuElderTcmHealthFragment = new FuElderTcmHealthFragment();
                fuElderTcmHealthFragment.initData(bundle);
                return fuElderTcmHealthFragment;

            case FuUiFrameManager.FU_TUBERCULOSIS_FIRST_FOLLOWUP:

                FuTuberculosisFirstFollowupFragment fuTuberculosisFirstFollowupFragment = new FuTuberculosisFirstFollowupFragment();
                fuTuberculosisFirstFollowupFragment.initData(bundle);
                return fuTuberculosisFirstFollowupFragment;
            case FuUiFrameManager.FU_TUBERCULOSIS_FOLLOWUP:
                FuTuberculosisFollowupFragment fuTuberculosisFollowupFragment = new FuTuberculosisFollowupFragment();
                fuTuberculosisFollowupFragment.initData(bundle);
                return fuTuberculosisFollowupFragment;
            case FuUiFrameManager.FU_CORONARYHEART_FOLLOWUP:
                FucoronaryHeartFragment fucoronaryHeartFragment = new FucoronaryHeartFragment();
                fucoronaryHeartFragment.initData(bundle);
                return fucoronaryHeartFragment;
            case FuUiFrameManager.FU_CEREBRALAPOPLEXY_FOLLOWUP:
                FuCerebralApoplexyFragment fuCerebralApoplexyFragment = new FuCerebralApoplexyFragment();
                fuCerebralApoplexyFragment.initData(bundle);
                return fuCerebralApoplexyFragment;
            case FuUiFrameManager.FU_CHILD_TCM_LEDGER:
                FuChildTcmLedgerFragment fuChildTcmLedgerFragment = new FuChildTcmLedgerFragment();
                fuChildTcmLedgerFragment.initData(bundle);
                return fuChildTcmLedgerFragment;
            case FuUiFrameManager.FU_CDCVACC_REPORT:
                FuCdcVaccreportFragment fuCdcVaccreportFragment = new FuCdcVaccreportFragment();
                fuCdcVaccreportFragment.initData(bundle);
                return fuCdcVaccreportFragment;
            case FuUiFrameManager.FU_CHANGE:
                FuChangeFragment fuChangeFragment = new FuChangeFragment();
                fuChangeFragment.initData(bundle);
                return fuChangeFragment;
            case FuUiFrameManager.FU_CDC_HAS:
                FuCdcHasFragment fuCdcHasFragment = new FuCdcHasFragment();
                fuCdcHasFragment.initData(bundle);
                return fuCdcHasFragment;
            case FuUiFrameManager.FU_CDC_NO:
                FuCdcNoFragment fuCdcNoFragment = new FuCdcNoFragment();
                fuCdcNoFragment.initData(bundle);
                return fuCdcNoFragment;


            case FuUiFrameManager.FU_HYPER_INFO:
                FuHyperInfoFragment fuHyperInfoFragment = new FuHyperInfoFragment();
                fuHyperInfoFragment.initData(bundle);
                return fuHyperInfoFragment;

            case FuUiFrameManager.FU_DIABETES_INFO:
                FuDiabetesInfoFragment fuDiabetesInfoFragment = new FuDiabetesInfoFragment();
                fuDiabetesInfoFragment.initData(bundle);
                return fuDiabetesInfoFragment;

            case FuUiFrameManager.FU_ELDERINFO:
                FuElderInfoFragment fuElderInfoFragment = new FuElderInfoFragment();
                fuElderInfoFragment.initData(bundle);
                return fuElderInfoFragment;
            case FuUiFrameManager.FU_CONARANYHEART_INFO:
                FuCoronaryHeartInfoFragment fuCoronaryHeartInfoFragment = new FuCoronaryHeartInfoFragment();
                fuCoronaryHeartInfoFragment.initData(bundle);
                return fuCoronaryHeartInfoFragment;
            case FuUiFrameManager.FU_CEREBRAL_INFO:
                FuCerebralInfoFragment fuCerebralInfoFragment = new FuCerebralInfoFragment();
                fuCerebralInfoFragment.initData(bundle);
                return fuCerebralInfoFragment;
            case FuUiFrameManager.FU_TUBERCULOSIS_INFO:
                FuTuberculosisInfoFragment fuTuberculosisInfoFragment = new FuTuberculosisInfoFragment();
                fuTuberculosisInfoFragment.initData(bundle);
                return fuTuberculosisInfoFragment;
            case FuUiFrameManager.FU_CHILD_INFO:
                FuChildInfoFragment fuChildInfoFragment = new FuChildInfoFragment();
                fuChildInfoFragment.initData(bundle);
                return fuChildInfoFragment;
            case FuUiFrameManager.FU_DISABILITY_HEAR:
                FuDisabilityHearFragment disabilityHearFragment = new FuDisabilityHearFragment();
                disabilityHearFragment.initData(bundle);
                return disabilityHearFragment;
            case FuUiFrameManager.FU_DISABILITY_INTELLIGENCE:
                FuDisabilityIntelligenceFragment disabilityIntelligenceFragment = new FuDisabilityIntelligenceFragment();
                disabilityIntelligenceFragment.initData(bundle);
                return disabilityIntelligenceFragment;
            case FuUiFrameManager.FU_DISABILITY_LIMB:
                FuDisabilityLimbFragment disabilityLimbFragment = new FuDisabilityLimbFragment();
                disabilityLimbFragment.initData(bundle);
                return disabilityLimbFragment;
            case FuUiFrameManager.FU_DISABILITY_VISUAL:
                FuDisabilityVisualFragment disabilityVisualFragment = new FuDisabilityVisualFragment();
                disabilityVisualFragment.initData(bundle);
                return disabilityVisualFragment;
            case FuUiFrameManager.FU_MATERNAL_REGISTER:
                FuMaternalRegisterFragment maternalRegisterFragment = new FuMaternalRegisterFragment();
                maternalRegisterFragment.initData(bundle);
                return maternalRegisterFragment;
            case FuUiFrameManager.FU_READ_CARD:
                ReadCardFragment readCardFragment = new ReadCardFragment();
                readCardFragment.initData(bundle);
                return readCardFragment;
            case FuUiFrameManager.FU_SET:
                FuSetFragment fuSetFragment = new FuSetFragment();
                return fuSetFragment;
            case FuUiFrameManager.FU_SET_PASSWORD:
                FuSetPasswordFragment fuSetPasswordFragment = new FuSetPasswordFragment();
                return fuSetPasswordFragment;
        }

        return new FuWelcomeFragment(); // 默认进入初始化页面
    }

    private Fragment createFragment(int action, Bundle bundle) {

        if (mFuFmArray == null) {

            return createNewFragment(action, bundle);

        } else {

            boolean isFond = false;

            int index = 0;

            for (; index < mFuFmArray.length; index++) {

                int lIdName = mFuFmArray[index].getmManagerNameId();

                if (lIdName == mCurrentNameId) {
                    isFond = true;
                    break;
                }
            }

            if (!isFond) {
                return createNewFragment(action, bundle);
            }

            ActionFragment[] lFragments = mFuFmArray[index].getmActionArray();

            if (lFragments == null) {

                return createNewFragment(action, bundle);
            }

            boolean isFondFragment = false;

            int i = 0;

            for (; i < lFragments.length; i++) {

                ActionFragment lFragment = lFragments[i];

                if (lFragment.getmEventAction() == action) {
                    isFondFragment = true;
                    break;
                }

            }

            if (!isFondFragment) {

                return createNewFragment(action, bundle);
            }

            Fragment lCurrentLocus = lFragments[i].getmFragment();

            if (bundle != null) {

                lCurrentLocus.setArguments(bundle);
            }

            return lCurrentLocus;
        }

    }

    public int CurrentAction() {

        return mCurrentAction;
    }

    private Fragment hasRunningLoaders(int action) {

        if (mFuFmArray == null) {

            return null;
        }

        boolean isFond = false;

        int index = 0;

        for (; index < mFuFmArray.length; index++) {

            int lIdName = mFuFmArray[index].getmManagerNameId();

            if (lIdName == mCurrentNameId) {
                isFond = true;
                break;
            }
        }

        if (!isFond) {
            return null;
        }

        isFond = false;

        ActionFragment[] lFragments = mFuFmArray[index].getmActionArray();

        int i = 0;

        for (; i < lFragments.length; i++) {

            ActionFragment lFragment = lFragments[i];

            if (lFragment.getmEventAction() == action) {
                isFond = true;
                break;
            }

        }

        if (!isFond) {
            return null;
        }

        return lFragments[i].getmFragment();

    }

    /**
     * @param fragementID
     * @param eventAction
     * @param bundle
     */

    public void replaceFragment(int fragementID, int eventAction, Bundle bundle) {

        if (mManager == null) {
            throw new IllegalStateException("Please init FragmentManager");
        }

        FragmentTransaction transaction = mManager.beginTransaction();

        Fragment lCurentFragment = hasRunningLoaders(eventAction);

        boolean isFond = false;

        int index = 0;

        for (; index < mFuFmArray.length; index++) {

            int lIdName = mFuFmArray[index].getmManagerNameId();

            if (lIdName == mCurrentNameId) {
                isFond = true;
                break;
            }
        }

        if (!isFond) {
            return;
        }

        ActionFragment[] lFragments = mFuFmArray[index].getmActionArray();

        if (lCurentFragment == null) { // 没有add过或者remove掉了

            lCurentFragment = createNewFragment(eventAction, bundle);

            transaction.hide(lFragments[lFragments.length - 1].getmFragment())
                    .add(fragementID, lCurentFragment).commit();

            ActionFragment lActionObj = new ActionFragment();
            lActionObj.setmEventAction(eventAction);
            lActionObj.setmFragment(lCurentFragment);
            addFragment(lActionObj);

        } else {

            transaction.hide(lFragments[lFragments.length - 1].getmFragment())
                    .show(lCurentFragment).commit();

            // ----排序，始终保证队列顶端为显示的当前Fragment
            isFond = false;

            int i = 0;

            for (; i < lFragments.length; i++) {

                ActionFragment lFragment = lFragments[i];

                if (lFragment.getmEventAction() == eventAction) {
                    isFond = true;
                    break;
                }

            }

            // -----------------排序，始终保持当前显示页在队列最前端

            ActionFragment[] lTemp = new ActionFragment[lFragments.length];

            if (i == 0) {

                System.arraycopy(lFragments, 1, lTemp, 0, lFragments.length - 1);
                lTemp[lTemp.length - 1] = lFragments[0];

            } else {

                System.arraycopy(lFragments, 0, lTemp, 0, i);
                System.arraycopy(lFragments, i + 1, lTemp, i, lFragments.length
                        - 1 - i);

                lTemp[lTemp.length - 1] = lFragments[i];
            }

            mFuFmArray[index].setmActionArray(lTemp);
            lTemp = null;
        }

        mCurrentAction = eventAction;
    }

    /**
     * 添加当前fragment
     *
     * @param fragment
     */
    private void addFragment(ActionFragment fragment) {

        if (fragment == null) {
            return;
        }

        if (mFuFmArray == null) {

            FuFmArray lArray = new FuFmArray();
            lArray.setmManagerNameId(mCurrentNameId);
            lArray.setmActionArray(fragment);

            mFuFmArray = new FuFmArray[1];

            mFuFmArray[0] = lArray;

        } else {

            boolean isFond = false;

            int index = 0;

            for (; index < mFuFmArray.length; index++) {

                int lIdName = mFuFmArray[index].getmManagerNameId();

                if (lIdName == mCurrentNameId) {
                    isFond = true;
                    break;
                }
            }

            if (isFond) {

                mFuFmArray[index].setmActionArray(fragment);

            } else {

                FuFmArray lArray = new FuFmArray();
                lArray.setmManagerNameId(mCurrentNameId);
                lArray.setmActionArray(fragment);

                FuFmArray[] lTemp = new FuFmArray[mFuFmArray.length + 1];

                System.arraycopy(mFuFmArray, 0, lTemp, 0, mFuFmArray.length);

                mFuFmArray = lTemp;

                lTemp = null;

                mFuFmArray[mFuFmArray.length - 1] = lArray;

            }
        }
    }

    /**
     * 删除指定模块的所有页面Fragment
     */
    public void deleteAllFragment(int lNameId) {

        if (mFuFmArray == null) {
            return;
        }

        boolean isFond = false;

        int index = 0;

        for (; index < mFuFmArray.length; index++) {

            int lIdName = mFuFmArray[index].getmManagerNameId();

            if (lIdName == mCurrentNameId) {
                isFond = true;
                break;
            }
        }

        if (isFond) {

            ActionFragment[] lTemp = mFuFmArray[index].getmActionArray();

            if (lTemp == null) {
                return;
            }

            FragmentTransaction transaction = mManager.beginTransaction();

            for (int i = 0; i < lTemp.length; i++) {

                Fragment lCurFragemt = lTemp[lTemp.length - 1].getmFragment();

                if (lCurFragemt == null) {
                    continue;
                }

                transaction.remove(lCurFragemt);

                transaction.commit();
            }

            lTemp = null;
            mFuFmArray[index].setmActionArray(lTemp);

        }
    }

    /**
     * 出栈操作，指定模块
     *
     * @param lNameId
     */
    private void popFragment(int lNameId) {

        if (mFuFmArray == null) {
            return;
        }

        boolean isFond = false;

        int index = 0;

        for (; index < mFuFmArray.length; index++) {

            int lIdName = mFuFmArray[index].getmManagerNameId();

            if (lIdName == lNameId) {
                isFond = true;
                break;
            }
        }

        if (isFond) {

            ActionFragment[] lFragments = mFuFmArray[index].getmActionArray();

            if (lFragments.length - 1 < 1) {

                lFragments = null;

                mFuFmArray[index].setmActionArray(lFragments);

                return;
            }

            ActionFragment[] lTemp = new ActionFragment[lFragments.length - 1];
            System.arraycopy(lFragments, 0, lTemp, 0, lTemp.length);
            lFragments = lTemp;
            lTemp = null;

            mFuFmArray[index].setmActionArray(lFragments);

        }

    }


    private int mCurrentAction;

    public int mcurrentAction() {

        return mCurrentAction;
    }

    public Fragment mCurrentFragment(int lNameId) {

        if (mFuFmArray == null) {
            return null;
        }

        boolean isFond = false;

        int index = 0;

        for (; index < mFuFmArray.length; index++) {

            int lIdName = mFuFmArray[index].getmManagerNameId();

            if (lIdName == mCurrentNameId) {
                isFond = true;
                break;
            }
        }

        if (!isFond) {
            return null;
        }

        ActionFragment[] lFragments = mFuFmArray[index].getmActionArray();

        return lFragments[lFragments.length - 1].getmFragment();
    }

    /**
     * 清除指定lNameId 当前fragementID 之前的所有该条件下的轨迹
     *
     * @param lNameId
     */
    public void clearBackFragment(int lNameId) {

        if (mFuFmArray == null) {
            return;
        }

        if (mManager == null) {
            throw new IllegalStateException("Please init FragmentManager");
        }

        boolean isFond = false;

        int index = 0;

        for (; index < mFuFmArray.length; index++) {

            int lIdName = mFuFmArray[index].getmManagerNameId();

            if (lIdName == lNameId) {
                isFond = true;
                break;
            }
        }

        if (!isFond) {

            return;
        }

        ActionFragment[] lFragments = mFuFmArray[index].getmActionArray();

        if (lFragments == null) {
            return;
        }

        if (lFragments.length < 2) {
            return;
        }

        FragmentTransaction transaction = mManager.beginTransaction();

        for (int i = 0; i < lFragments.length - 1; i++) {

            transaction.remove(lFragments[i].getmFragment());

        }

        transaction.commit();

        ActionFragment[] lTemp = new ActionFragment[1];
        lTemp[0] = lFragments[lFragments.length - 1];
        lFragments = lTemp;
        lTemp = null;

        mFuFmArray[index].setmActionArray(lFragments);

    }

    /**
     * 清除指定lNameId 当前fragementID和第一个fragment 之间的所有该条件下的轨迹
     *
     * @param lNameId
     */
    public void clearBackFragmentTopAndBottom(int lNameId) {

        if (mFuFmArray == null) {
            return;
        }

        if (mManager == null) {
            throw new IllegalStateException("Please init FragmentManager");
        }

        boolean isFond = false;

        int index = 0;

        for (; index < mFuFmArray.length; index++) {

            int lIdName = mFuFmArray[index].getmManagerNameId();

            if (lIdName == lNameId) {
                isFond = true;
                break;
            }
        }

        if (!isFond) {

            return;
        }

        ActionFragment[] lFragments = mFuFmArray[index].getmActionArray();

        if (lFragments == null) {
            return;
        }

        if (lFragments.length < 3) { // 至少3层，才会出现上下中间删除的可能
            return;
        }

        FragmentTransaction transaction = mManager.beginTransaction();

        for (int i = 1; i < lFragments.length - 1; i++) {

            transaction.remove(lFragments[i].getmFragment());

        }

        transaction.commit();

        ActionFragment[] lTemp = new ActionFragment[2];
        lTemp[0] = lFragments[0];
        lTemp[1] = lFragments[lFragments.length - 1];
        lFragments = lTemp;
        lTemp = null;

        mFuFmArray[index].setmActionArray(lFragments);

    }

    /**
     * 清除该视图下的所有frament
     *
     * @param lNameId
     */
    public void clearBackFragmentAll(int lNameId) {

        if (mFuFmArray == null) {
            return;
        }

        if (mManager == null) {
            throw new IllegalStateException("Please init FragmentManager");
        }

        boolean isFond = false;

        int index = 0;

        for (; index < mFuFmArray.length; index++) {

            int lIdName = mFuFmArray[index].getmManagerNameId();

            if (lIdName == lNameId) {
                isFond = true;
                break;
            }
        }

        if (!isFond) {

            return;
        }

        // mFuFmArray[index]=null;

        ActionFragment[] lFragments = mFuFmArray[index].getmActionArray();

        if (lFragments == null) {
            return;
        }

        FragmentTransaction transaction = mManager.beginTransaction();

        for (int i = 0; i < lFragments.length; i++) {

            transaction.remove(lFragments[i].getmFragment());

            popFragment(lNameId);
        }

        transaction.commit();
    }

    /**
     * 返回上一次访问的页面
     *
     * @param fragementID
     * @return
     */
    public boolean gotoBackFragment(int lNameId, int fragementID) {

        if (mFuFmArray == null) {
            return false;
        }

        if (mManager == null) {
            throw new IllegalStateException("Please init FragmentManager");
        }

        boolean isFond = false;

        int index = 0;

        for (; index < mFuFmArray.length; index++) {

            int lIdName = mFuFmArray[index].getmManagerNameId();

            if (lIdName == lNameId) {
                isFond = true;
                break;
            }
        }

        if (!isFond) {

            return false;
        }

        ActionFragment[] lFragments = mFuFmArray[index].getmActionArray();

        int lCurrentAction = lFragments[lFragments.length - 1]
                .getmEventAction();

        if (lCurrentAction == FuUiFrameManager.FU_MAIN_HOME
                || lCurrentAction == FuUiFrameManager.FU_LOGIN) { // 首页或登录页面点击返回，清除所有的Fragment,直接退出程序

            clearBackFragmentAll(MAIN);
            clearBackFragmentAll(LOGIN_REGIST);
            clearBackFragmentAll(CONTENT);

            return false;
        }

        if (lFragments.length < 2) { // 查找当前视图的上一级视图的归属activity 的Action

            popFragment(lNameId);

            ActionFragment[] lFragmentsPre = null;

            if (index < 1) {

                lFragmentsPre = mFuFmArray[0].getmActionArray();

            } else {

                lFragmentsPre = mFuFmArray[index - 1].getmActionArray();
            }

            if (lFragmentsPre == null || lFragmentsPre.length < 1) {
                return false;
            }

            mCurrentAction = lFragmentsPre[lFragmentsPre.length - 1]
                    .getmEventAction();

            return false;
        }

        FragmentTransaction transaction = mManager.beginTransaction();

        transaction.remove(lFragments[lFragments.length - 1].getmFragment());

        popFragment(lNameId);

        lFragments = mFuFmArray[index].getmActionArray();

        transaction.show(lFragments[lFragments.length - 1].getmFragment());

        transaction.commit();

        mCurrentAction = lFragments[lFragments.length - 1].getmEventAction();

        return true;
    }
}
