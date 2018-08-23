package entity;

import org.hibernate.annotations.Entity;

@Entity
public class Account {
	 private Long id;
	    private String accountName;//账户名
	    private int accountType;//账户类型 (1：基本账户(银行账户); 2：现金账户;3：特殊账户(汇票账户);4:其它账户)
	    private String accountNumber;//银行账号
	    private double amounts;//账户金额
	    private Long createrId;//创建人id
	    private Long createTime;//创建时间
	    private Long updaterId;//更新人id
	    private Long updateTime;//更新时间
	    private char isActive;//是否有效
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAccountName() {
			return accountName;
		}
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		public int getAccountType() {
			return accountType;
		}
		public void setAccountType(int accountType) {
			this.accountType = accountType;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public double getAmounts() {
			return amounts;
		}
		public void setAmounts(double amounts) {
			this.amounts = amounts;
		}
		public Long getCreaterId() {
			return createrId;
		}
		public void setCreaterId(Long createrId) {
			this.createrId = createrId;
		}
		public Long getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Long createTime) {
			this.createTime = createTime;
		}
		public Long getUpdaterId() {
			return updaterId;
		}
		public void setUpdaterId(Long updaterId) {
			this.updaterId = updaterId;
		}
		public Long getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Long updateTime) {
			this.updateTime = updateTime;
		}
		public char getIsActive() {
			return isActive;
		}
		public void setIsActive(char isActive) {
			this.isActive = isActive;
		}
		public Account(Long id, String accountName, int accountType, String accountNumber, double amounts,
				Long createrId, Long createTime, Long updaterId, Long updateTime, char isActive) {
			super();
			this.id = id;
			this.accountName = accountName;
			this.accountType = accountType;
			this.accountNumber = accountNumber;
			this.amounts = amounts;
			this.createrId = createrId;
			this.createTime = createTime;
			this.updaterId = updaterId;
			this.updateTime = updateTime;
			this.isActive = isActive;
		}
	    public Account() {}
	   
}
