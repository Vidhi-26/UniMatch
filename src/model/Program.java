package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {

	private String university;
	private String program;
	private Boolean coop;
	private String[] preReq;
	private double minMark;
	private double maxMark;
	private Boolean extraCurr;
	private double budget;
	private Boolean residence;
	private double xCoor;
	private double yCoor;
	private int rank;
	private String hyperlink;
	
	
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public Boolean getCoop() {
		return coop;
	}
	public void setCoop(Boolean coop) {
		this.coop = coop;
	}
	public String[] getPreReq() {
		return preReq;
	}
	public void setPreReq(String[] preReq) {
		this.preReq = preReq;
	}
	public double getMinMark() {
		return minMark;
	}
	public void setMinMark(double minMark) {
		this.minMark = minMark;
	}
	public double getMaxMark() {
		return maxMark;
	}
	public void setMaxMark(double maxMark) {
		this.maxMark = maxMark;
	}
	public Boolean getExtraCurr() {
		return extraCurr;
	}
	public void setExtraCurr(Boolean extraCurr) {
		this.extraCurr = extraCurr;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public Boolean getResidence() {
		return residence;
	}
	public void setResidence(Boolean residence) {
		this.residence = residence;
	}
	public double getxCoor() {
		return xCoor;
	}
	public void setxCoor(double xCoor) {
		this.xCoor = xCoor;
	}
	public double getyCoor() {
		return yCoor;
	}
	public void setyCoor(double yCoor) {
		this.yCoor = yCoor;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getHyperlink() {
		return hyperlink;
	}
	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}
	@Override
	public String toString() {
		return "Program [university=" + university + ", program=" + program + ", coop=" + coop + ", preReq="
				+ Arrays.toString(preReq) + ", minMark=" + minMark + ", maxMark=" + maxMark + ", extraCurr=" + extraCurr
				+ ", budget=" + budget + ", residence=" + residence + ", xCoor=" + xCoor + ", yCoor=" + yCoor
				+ ", rank=" + rank + ", hyperlink=" + hyperlink + "]";
	}
	


}