package com.hmmes.bean;

import java.util.List;

public class CpBean extends BaseBean {
	
	
	private String cplb;//   ��Ʒ���
	private String cpxh;//   ��Ʒ�ͺ�
	private String cpgg;//   ��Ʒ���
	private String cpdy;//   ��ѹ�ȼ�
	private String cpdw;//   ������λ
	private String xsjg;//   ��о�ṹ
    private Integer zxs;//   ����оо��
	private Double zzl;//   ����о��λ��������
    private Integer lxs;//   ����оо��
	private Double lzl;//   ����о��λ��������
	private Double cpgs;//   ��Ʒ�ն˹�ʱ

    private int subCountGx;//����������ϸ,�����ݿ��ֶ��޹�

	//������Ʒ������ϸcp_gxmx
	private List<CpgxmxBean> gxmxs;

	public List<CpgxmxBean> getGxmxs() {
		return this.gxmxs;
	}
	public void setGxmxs(List<CpgxmxBean> gxmxs) {
		this.gxmxs = gxmxs;
	}	
	public int getSubCountGx() {
		return this.subCountGx;
	}
	public void setSubCountGx(int subCountGx) {
		this.subCountGx = subCountGx;
	}	

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCplb() {
		return this.cplb;
	}
	public void setCplb(String cplb) {
		this.cplb = cplb;
	}

	public String getCpxh() {
	    return this.cpxh;
	}
	public void setCpxh(String cpxh) {
	    this.cpxh=cpxh;
	}
	public String getCpgg() {
	    return this.cpgg;
	}
	public void setCpgg(String cpgg) {
	    this.cpgg=cpgg;
	}
	public String getCpdy() {
	    return this.cpdy;
	}
	public void setCpdy(String cpdy) {
	    this.cpdy=cpdy;
	}

	public String getCpdw() {
	    return this.cpdw;
	}
	public void setCpdw(String cpdw) {
	    this.cpdw=cpdw;
	}
	public String getXsjg() {
	    return this.xsjg;
	}
	public void setXsjg(String xsjg) {
	    this.xsjg=xsjg;
	}
	public Integer getZxs() {
		return this.zxs;
	}
	public void setZxs(Integer zxs) {
		this.zxs = zxs;
	}
	public Double getZzl() {
	    return this.zzl;
	}
	public void setZzl(Double zzl) {
	    this.zzl=zzl;
	}

	public Integer getLxs() {
		return this.lxs;
	}
	public void setLxs(Integer lxs) {
		this.lxs = lxs;
	}
	public Double getLzl() {
	    return this.lzl;
	}
	public void setLzl(Double lzl) {
	    this.lzl=lzl;
	}
	public Double getCpgs() {
	    return this.cpgs;
	}
	public void setCpgs(Double cpgs) {
	    this.cpgs=cpgs;
	}

}