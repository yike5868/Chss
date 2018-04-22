package net.greatsoft.main.db.po.maternal;

import net.greatsoft.main.db.po.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 
 * @author AlphGo
 * @date 2016年7月14日 上午12:12:02
 * @Description: 分娩登记-新生儿记录情况数据模型
 *
 */
@Entity
public class MaternalNewbornSituation  extends Entry {

	/**
	 * 新生儿记录ID
	 */
	private String newbornSituationId;

	/**
	 * 孕产妇基本信息ID
	 */
	
	private String maternalInfoId;

	/**
	 * 个人档案ID
	 */
	
	private String personInfoId;

	/**
	 * 分娩登记ID
	 */
	
	private String maternalChildbirthId;

	/**
	 * 新生儿情况性别
	 */
	
	private String babySex;

	/**
	 * 新生儿情况生产情况
	 */
	
	private String babyGivebirthSituation;

	/**
	 * 新生儿情况体重
	 */
	
	private Double babyWeight;

	/**
	 * 新生儿情况胸围
	 */
	
	private Double babyChest;

	/**
	 * 新生儿情况身长
	 */
	
	private Double babyHeight;

	/**
	 * 新生儿情况头围
	 */
	
	private Double babyHeadSize;

	/**
	 * 新生儿情况畸形
	 */
	
	private String babyMalformation;

	/**
	 * 新生儿情况窒息
	 */
	
	private String babySuffocate;

	/**
	 * 新生儿情况新生儿死亡情况
	 */
	
	private String babyDeath;

	/**
	 * 新生儿情况apgar评分，1分
	 */
	private Integer babyApgar1;

	/**
	 * 新生儿情况apgar评分，5分
	 */
	private Integer babyApgar5;

	/**
	 * 新生儿情况apgar评分，10分
	 */
	private Integer babyApgar10;

	/**
	 * 卡介苗接种
	 */
	
	private String bcgVaccineInoculability;

	/**
	 * 卡介苗接种未种原因
	 */
	
	private String bcgVaccineReason;

	/**
	 * 乙肝疫苗接种
	 */
	
	private String hepatitisBVaccine;

	/**
	 * 乙肝疫苗接种未种原因
	 */
	
	private String hepatitisBReason;

	/**
	 * 苯丙酮尿症筛查
	 */
	
	private String phenylketonuriaExamination;

	/**
	 * 苯丙酮尿症结果
	 */
	
	private String phenylketonuriaResult;

	/**
	 * 甲状腺功能低下筛查
	 */
	
	private String thyroidHypofunction;

	/**
	 * 甲状腺功能低下结果
	 */
	
	private String thyroidHypofunctionResult;

	/**
	 * 听力筛查
	 */
	
	private String hearingExamination;

	/**
	 * 听力结果
	 */
	
	private String hearingResult;

	public String getHearingResult() {
		return this.hearingResult;
	}

	public void setHearingResult(String hearingResult) {
		this.hearingResult = hearingResult;
	}

	public String getHearingExamination() {
		return this.hearingExamination;
	}

	public void setHearingExamination(String hearingExamination) {
		this.hearingExamination = hearingExamination;
	}

	public String getThyroidHypofunctionResult() {
		return this.thyroidHypofunctionResult;
	}

	public void setThyroidHypofunctionResult(String thyroidHypofunctionResult) {
		this.thyroidHypofunctionResult = thyroidHypofunctionResult;
	}

	public String getThyroidHypofunction() {
		return this.thyroidHypofunction;
	}

	public void setThyroidHypofunction(String thyroidHypofunction) {
		this.thyroidHypofunction = thyroidHypofunction;
	}

	public String getPhenylketonuriaResult() {
		return this.phenylketonuriaResult;
	}

	public void setPhenylketonuriaResult(String phenylketonuriaResult) {
		this.phenylketonuriaResult = phenylketonuriaResult;
	}

	public String getPhenylketonuriaExamination() {
		return this.phenylketonuriaExamination;
	}

	public void setPhenylketonuriaExamination(String phenylketonuriaExamination) {
		this.phenylketonuriaExamination = phenylketonuriaExamination;
	}

	public String getHepatitisBReason() {
		return this.hepatitisBReason;
	}

	public void setHepatitisBReason(String hepatitisBReason) {
		this.hepatitisBReason = hepatitisBReason;
	}

	public String getHepatitisBVaccine() {
		return this.hepatitisBVaccine;
	}

	public void setHepatitisBVaccine(String hepatitisBVaccine) {
		this.hepatitisBVaccine = hepatitisBVaccine;
	}

	public String getBcgVaccineReason() {
		return this.bcgVaccineReason;
	}

	public void setBcgVaccineReason(String bcgVaccineReason) {
		this.bcgVaccineReason = bcgVaccineReason;
	}

	public String getBcgVaccineInoculability() {
		return this.bcgVaccineInoculability;
	}

	public void setBcgVaccineInoculability(String bcgVaccineInoculability) {
		this.bcgVaccineInoculability = bcgVaccineInoculability;
	}

	public Integer getBabyApgar10() {
		return this.babyApgar10;
	}

	public void setBabyApgar10(Integer babyApgar10) {
		this.babyApgar10 = babyApgar10;
	}

	public Integer getBabyApgar5() {
		return this.babyApgar5;
	}

	public void setBabyApgar5(Integer babyApgar5) {
		this.babyApgar5 = babyApgar5;
	}

	public Integer getBabyApgar1() {
		return this.babyApgar1;
	}

	public void setBabyApgar1(Integer babyApgar1) {
		this.babyApgar1 = babyApgar1;
	}

	public String getBabyDeath() {
		return this.babyDeath;
	}

	public void setBabyDeath(String babyDeath) {
		this.babyDeath = babyDeath;
	}

	public String getBabySuffocate() {
		return this.babySuffocate;
	}

	public void setBabySuffocate(String babySuffocate) {
		this.babySuffocate = babySuffocate;
	}

	public String getBabyMalformation() {
		return this.babyMalformation;
	}

	public void setBabyMalformation(String babyMalformation) {
		this.babyMalformation = babyMalformation;
	}

	public Double getBabyHeadSize() {
		return this.babyHeadSize;
	}

	public void setBabyHeadSize(Double babyHeadSize) {
		this.babyHeadSize = babyHeadSize;
	}

	public Double getBabyHeight() {
		return this.babyHeight;
	}

	public void setBabyHeight(Double babyHeight) {
		this.babyHeight = babyHeight;
	}

	public Double getBabyChest() {
		return this.babyChest;
	}

	public void setBabyChest(Double babyChest) {
		this.babyChest = babyChest;
	}

	public Double getBabyWeight() {
		return this.babyWeight;
	}

	public void setBabyWeight(Double babyWeight) {
		this.babyWeight = babyWeight;
	}

	public String getBabyGivebirthSituation() {
		return this.babyGivebirthSituation;
	}

	public void setBabyGivebirthSituation(String babyGivebirthSituation) {
		this.babyGivebirthSituation = babyGivebirthSituation;
	}

	public String getBabySex() {
		return this.babySex;
	}

	public void setBabySex(String babySex) {
		this.babySex = babySex;
	}

	public String getMaternalChildbirthId() {
		return this.maternalChildbirthId;
	}

	public void setMaternalChildbirthId(String maternalChildbirthId) {
		this.maternalChildbirthId = maternalChildbirthId;
	}

	public String getPersonInfoId() {
		return this.personInfoId;
	}

	public void setPersonInfoId(String personInfoId) {
		this.personInfoId = personInfoId;
	}

	public String getMaternalInfoId() {
		return this.maternalInfoId;
	}

	public void setMaternalInfoId(String maternalInfoId) {
		this.maternalInfoId = maternalInfoId;
	}

	public String getNewbornSituationId() {
		return this.newbornSituationId;
	}

	public void setNewbornSituationId(String newbornSituationId) {
		this.newbornSituationId = newbornSituationId;
	}

	@Generated(hash = 1576081355)
	public MaternalNewbornSituation(String newbornSituationId,
			String maternalInfoId, String personInfoId, String maternalChildbirthId,
			String babySex, String babyGivebirthSituation, Double babyWeight,
			Double babyChest, Double babyHeight, Double babyHeadSize,
			String babyMalformation, String babySuffocate, String babyDeath,
			Integer babyApgar1, Integer babyApgar5, Integer babyApgar10,
			String bcgVaccineInoculability, String bcgVaccineReason,
			String hepatitisBVaccine, String hepatitisBReason,
			String phenylketonuriaExamination, String phenylketonuriaResult,
			String thyroidHypofunction, String thyroidHypofunctionResult,
			String hearingExamination, String hearingResult) {
		this.newbornSituationId = newbornSituationId;
		this.maternalInfoId = maternalInfoId;
		this.personInfoId = personInfoId;
		this.maternalChildbirthId = maternalChildbirthId;
		this.babySex = babySex;
		this.babyGivebirthSituation = babyGivebirthSituation;
		this.babyWeight = babyWeight;
		this.babyChest = babyChest;
		this.babyHeight = babyHeight;
		this.babyHeadSize = babyHeadSize;
		this.babyMalformation = babyMalformation;
		this.babySuffocate = babySuffocate;
		this.babyDeath = babyDeath;
		this.babyApgar1 = babyApgar1;
		this.babyApgar5 = babyApgar5;
		this.babyApgar10 = babyApgar10;
		this.bcgVaccineInoculability = bcgVaccineInoculability;
		this.bcgVaccineReason = bcgVaccineReason;
		this.hepatitisBVaccine = hepatitisBVaccine;
		this.hepatitisBReason = hepatitisBReason;
		this.phenylketonuriaExamination = phenylketonuriaExamination;
		this.phenylketonuriaResult = phenylketonuriaResult;
		this.thyroidHypofunction = thyroidHypofunction;
		this.thyroidHypofunctionResult = thyroidHypofunctionResult;
		this.hearingExamination = hearingExamination;
		this.hearingResult = hearingResult;
	}

	@Generated(hash = 2130492245)
	public MaternalNewbornSituation() {

	}

}
