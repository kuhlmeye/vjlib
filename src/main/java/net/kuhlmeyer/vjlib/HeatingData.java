package net.kuhlmeyer.vjlib;

import java.io.Serializable;
import java.util.Date;

public class HeatingData implements Serializable {

    private Date timestamp;
	private Double tempAussen;
	private Double tempWWIst;
	private Double tempWWSoll;
	private Double tempKesselIst;
	private Double tempKesselSoll;
	private Double leistung;
	private Double tempVorlaufIstM1;
	private Double tempVorlaufIstM2;
	private Double tempRuecklaufIstM2;
	private Double tempVorlaufSollM1;
	private Double tempKollektor;
	private Double tempSpeicherUnten;
	private Double tempRaumNormalSollM1;
	private Double tempRaumReduziertSollM1;
	private Integer brennerStarts;
	private Double verbrauch;
	private Double brennerStunden1;
	private Boolean statusPumpeM1;
	private Boolean statusSpeicherladepumpe;
	private Boolean statusPumpeZirkulation;
	private Boolean statusPumpeSolar;
	private Double mischerM1;
	private Boolean statusSolarNachladeunterdrueckung;
	private String betriebsArtM1;
	private Boolean statusSparbetriebM1;
	private Boolean statusPartyBetriebM1;
	private Integer solarStunden;
	private Integer solarLeistung;
	private Double tempPartyM1;
	private Double neigungM1;
	private Double niveauM1;


	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Double getTempAussen() {
		return tempAussen;
	}

	public void setTempAussen(Double tempAussen) {
		this.tempAussen = tempAussen;
	}

	public Double getTempWWIst() {
		return tempWWIst;
	}

	public void setTempWWIst(Double tempWWIst) {
		this.tempWWIst = tempWWIst;
	}

	public Double getTempWWSoll() {
		return tempWWSoll;
	}

	public void setTempWWSoll(Double tempWWSoll) {
		this.tempWWSoll = tempWWSoll;
	}

	public Double getTempKesselIst() {
		return tempKesselIst;
	}

	public void setTempKesselIst(Double tempKesselIst) {
		this.tempKesselIst = tempKesselIst;
	}

	public Double getTempKesselSoll() {
		return tempKesselSoll;
	}

	public void setTempKesselSoll(Double tempKesselSoll) {
		this.tempKesselSoll = tempKesselSoll;
	}

	public Double getLeistung() {
		return leistung;
	}

	public void setLeistung(Double leistung) {
		this.leistung = leistung;
	}

	public Double getTempVorlaufIstM1() {
		return tempVorlaufIstM1;
	}

	public void setTempVorlaufIstM1(Double tempVorlaufIstM1) {
		this.tempVorlaufIstM1 = tempVorlaufIstM1;
	}

	public Double getTempVorlaufIstM2() {
		return tempVorlaufIstM2;
	}

	public void setTempVorlaufIstM2(Double tempVorlaufIstM2) {
		this.tempVorlaufIstM2 = tempVorlaufIstM2;
	}

	public Double getTempRuecklaufIstM2() {
		return tempRuecklaufIstM2;
	}

	public void setTempRuecklaufIstM2(Double tempRuecklaufIstM2) {
		this.tempRuecklaufIstM2 = tempRuecklaufIstM2;
	}

	public Double getTempVorlaufSollM1() {
		return tempVorlaufSollM1;
	}

	public void setTempVorlaufSollM1(Double tempVorlaufSollM1) {
		this.tempVorlaufSollM1 = tempVorlaufSollM1;
	}

	public Double getTempKollektor() {
		return tempKollektor;
	}

	public void setTempKollektor(Double tempKollektor) {
		this.tempKollektor = tempKollektor;
	}

	public Double getTempSpeicherUnten() {
		return tempSpeicherUnten;
	}

	public void setTempSpeicherUnten(Double tempSpeicherUnten) {
		this.tempSpeicherUnten = tempSpeicherUnten;
	}

	public Double getTempRaumNormalSollM1() {
		return tempRaumNormalSollM1;
	}

	public void setTempRaumNormalSollM1(Double tempRaumNormalSollM1) {
		this.tempRaumNormalSollM1 = tempRaumNormalSollM1;
	}

	public Double getTempRaumReduziertSollM1() {
		return tempRaumReduziertSollM1;
	}

	public void setTempRaumReduziertSollM1(Double tempoRaumReduziertSollM1) {
		this.tempRaumReduziertSollM1 = tempoRaumReduziertSollM1;
	}

	public Integer getBrennerStarts() {
		return brennerStarts;
	}

	public void setBrennerStarts(Integer brennerStarts) {
		this.brennerStarts = brennerStarts;
	}

	public Double getVerbrauch() {
		return verbrauch;
	}

	public void setVerbrauch(Double verbrauch) {
		this.verbrauch = verbrauch;
	}

	public Double getBrennerStunden1() {
		return brennerStunden1;
	}

	public void setBrennerStunden1(Double brennerStunden1) {
		this.brennerStunden1 = brennerStunden1;
	}

	public Boolean getStatusPumpeM1() {
		return statusPumpeM1;
	}

	public void setStatusPumpeM1(Boolean statusPumpeM1) {
		this.statusPumpeM1 = statusPumpeM1;
	}

	public Boolean getStatusSpeicherladepumpe() {
		return statusSpeicherladepumpe;
	}

	public void setStatusSpeicherladepumpe(Boolean statusSpeicherladepumpe) {
		this.statusSpeicherladepumpe = statusSpeicherladepumpe;
	}

	public Boolean getStatusPumpeZirkulation() {
		return statusPumpeZirkulation;
	}

	public void setStatusPumpeZirkulation(Boolean statusPumpeZirkulation) {
		this.statusPumpeZirkulation = statusPumpeZirkulation;
	}

	public Boolean getStatusPumpeSolar() {
		return statusPumpeSolar;
	}

	public void setStatusPumpeSolar(Boolean statusPumpeSolar) {
		this.statusPumpeSolar = statusPumpeSolar;
	}

	public Double getMischerM1() {
		return mischerM1;
	}

	public void setMischerM1(Double mischerM1) {
		this.mischerM1 = mischerM1;
	}

	public Boolean getStatusSolarNachladeunterdrueckung() {
		return statusSolarNachladeunterdrueckung;
	}

	public void setStatusSolarNachladeunterdrueckung(Boolean statusSolarNachladeunterdrueckung) {
		this.statusSolarNachladeunterdrueckung = statusSolarNachladeunterdrueckung;
	}

	public String getBetriebsArtM1() {
		return betriebsArtM1;
	}

	public void setBetriebsArtM1(String betriebsArtM1) {
		this.betriebsArtM1 = betriebsArtM1;
	}

	public Boolean getStatusSparbetriebM1() {
		return statusSparbetriebM1;
	}

	public void setStatusSparbetriebM1(Boolean statusSparbetriebM1) {
		this.statusSparbetriebM1 = statusSparbetriebM1;
	}

	public Boolean getStatusPartyBetriebM1() {
		return statusPartyBetriebM1;
	}

	public void setStatusPartyBetriebM1(Boolean statusPartyBetriebM1) {
		this.statusPartyBetriebM1 = statusPartyBetriebM1;
	}

	public Integer getSolarStunden() {
		return solarStunden;
	}

	public void setSolarStunden(Integer solarStunden) {
		this.solarStunden = solarStunden;
	}

	public Integer getSolarLeistung() {
		return solarLeistung;
	}

	public void setSolarLeistung(Integer solarLeistung) {
		this.solarLeistung = solarLeistung;
	}

	public Double getTempPartyM1() {
		return tempPartyM1;
	}

	public void setTempPartyM1(Double tempPartyM1) {
		this.tempPartyM1 = tempPartyM1;
	}

	public Double getNeigungM1() {
		return neigungM1;
	}

	public void setNeigungM1(Double neigungM1) {
		this.neigungM1 = neigungM1;
	}

	public Double getNiveauM1() {
		return niveauM1;
	}

	public void setNiveauM1(Double niveauM1) {
		this.niveauM1 = niveauM1;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeatingData that = (HeatingData) o;

        if (betriebsArtM1 != null ? !betriebsArtM1.equals(that.betriebsArtM1) : that.betriebsArtM1 != null) return false;
        if (brennerStarts != null ? !brennerStarts.equals(that.brennerStarts) : that.brennerStarts != null) return false;
        if (brennerStunden1 != null ? !brennerStunden1.equals(that.brennerStunden1) : that.brennerStunden1 != null) return false;
        if (leistung != null ? !leistung.equals(that.leistung) : that.leistung != null) return false;
        if (mischerM1 != null ? !mischerM1.equals(that.mischerM1) : that.mischerM1 != null) return false;
        if (neigungM1 != null ? !neigungM1.equals(that.neigungM1) : that.neigungM1 != null) return false;
        if (niveauM1 != null ? !niveauM1.equals(that.niveauM1) : that.niveauM1 != null) return false;
        if (solarLeistung != null ? !solarLeistung.equals(that.solarLeistung) : that.solarLeistung != null) return false;
        if (solarStunden != null ? !solarStunden.equals(that.solarStunden) : that.solarStunden != null) return false;
        if (statusPartyBetriebM1 != null ? !statusPartyBetriebM1.equals(that.statusPartyBetriebM1) : that.statusPartyBetriebM1 != null) return false;
        if (statusPumpeM1 != null ? !statusPumpeM1.equals(that.statusPumpeM1) : that.statusPumpeM1 != null) return false;
        if (statusPumpeSolar != null ? !statusPumpeSolar.equals(that.statusPumpeSolar) : that.statusPumpeSolar != null) return false;
        if (statusPumpeZirkulation != null ? !statusPumpeZirkulation.equals(that.statusPumpeZirkulation) : that.statusPumpeZirkulation != null) return false;
        if (statusSolarNachladeunterdrueckung != null ? !statusSolarNachladeunterdrueckung.equals(that.statusSolarNachladeunterdrueckung) : that.statusSolarNachladeunterdrueckung != null)
            return false;
        if (statusSparbetriebM1 != null ? !statusSparbetriebM1.equals(that.statusSparbetriebM1) : that.statusSparbetriebM1 != null) return false;
        if (statusSpeicherladepumpe != null ? !statusSpeicherladepumpe.equals(that.statusSpeicherladepumpe) : that.statusSpeicherladepumpe != null)
            return false;
        if (tempAussen != null ? !tempAussen.equals(that.tempAussen) : that.tempAussen != null) return false;
        if (tempKesselIst != null ? !tempKesselIst.equals(that.tempKesselIst) : that.tempKesselIst != null) return false;
        if (tempKesselSoll != null ? !tempKesselSoll.equals(that.tempKesselSoll) : that.tempKesselSoll != null) return false;
        if (tempKollektor != null ? !tempKollektor.equals(that.tempKollektor) : that.tempKollektor != null) return false;
        if (tempPartyM1 != null ? !tempPartyM1.equals(that.tempPartyM1) : that.tempPartyM1 != null) return false;
        if (tempRaumNormalSollM1 != null ? !tempRaumNormalSollM1.equals(that.tempRaumNormalSollM1) : that.tempRaumNormalSollM1 != null) return false;
        if (tempRaumReduziertSollM1 != null ? !tempRaumReduziertSollM1.equals(that.tempRaumReduziertSollM1) : that.tempRaumReduziertSollM1 != null)
            return false;
        if (tempRuecklaufIstM2 != null ? !tempRuecklaufIstM2.equals(that.tempRuecklaufIstM2) : that.tempRuecklaufIstM2 != null) return false;
        if (tempSpeicherUnten != null ? !tempSpeicherUnten.equals(that.tempSpeicherUnten) : that.tempSpeicherUnten != null) return false;
        if (tempVorlaufIstM1 != null ? !tempVorlaufIstM1.equals(that.tempVorlaufIstM1) : that.tempVorlaufIstM1 != null) return false;
        if (tempVorlaufIstM2 != null ? !tempVorlaufIstM2.equals(that.tempVorlaufIstM2) : that.tempVorlaufIstM2 != null) return false;
        if (tempVorlaufSollM1 != null ? !tempVorlaufSollM1.equals(that.tempVorlaufSollM1) : that.tempVorlaufSollM1 != null) return false;
        if (tempWWIst != null ? !tempWWIst.equals(that.tempWWIst) : that.tempWWIst != null) return false;
        if (tempWWSoll != null ? !tempWWSoll.equals(that.tempWWSoll) : that.tempWWSoll != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (verbrauch != null ? !verbrauch.equals(that.verbrauch) : that.verbrauch != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = timestamp != null ? timestamp.hashCode() : 0;
        result = 31 * result + (tempAussen != null ? tempAussen.hashCode() : 0);
        result = 31 * result + (tempWWIst != null ? tempWWIst.hashCode() : 0);
        result = 31 * result + (tempWWSoll != null ? tempWWSoll.hashCode() : 0);
        result = 31 * result + (tempKesselIst != null ? tempKesselIst.hashCode() : 0);
        result = 31 * result + (tempKesselSoll != null ? tempKesselSoll.hashCode() : 0);
        result = 31 * result + (leistung != null ? leistung.hashCode() : 0);
        result = 31 * result + (tempVorlaufIstM1 != null ? tempVorlaufIstM1.hashCode() : 0);
        result = 31 * result + (tempVorlaufIstM2 != null ? tempVorlaufIstM2.hashCode() : 0);
        result = 31 * result + (tempRuecklaufIstM2 != null ? tempRuecklaufIstM2.hashCode() : 0);
        result = 31 * result + (tempVorlaufSollM1 != null ? tempVorlaufSollM1.hashCode() : 0);
        result = 31 * result + (tempKollektor != null ? tempKollektor.hashCode() : 0);
        result = 31 * result + (tempSpeicherUnten != null ? tempSpeicherUnten.hashCode() : 0);
        result = 31 * result + (tempRaumNormalSollM1 != null ? tempRaumNormalSollM1.hashCode() : 0);
        result = 31 * result + (tempRaumReduziertSollM1 != null ? tempRaumReduziertSollM1.hashCode() : 0);
        result = 31 * result + (brennerStarts != null ? brennerStarts.hashCode() : 0);
        result = 31 * result + (verbrauch != null ? verbrauch.hashCode() : 0);
        result = 31 * result + (brennerStunden1 != null ? brennerStunden1.hashCode() : 0);
        result = 31 * result + (statusPumpeM1 != null ? statusPumpeM1.hashCode() : 0);
        result = 31 * result + (statusSpeicherladepumpe != null ? statusSpeicherladepumpe.hashCode() : 0);
        result = 31 * result + (statusPumpeZirkulation != null ? statusPumpeZirkulation.hashCode() : 0);
        result = 31 * result + (statusPumpeSolar != null ? statusPumpeSolar.hashCode() : 0);
        result = 31 * result + (mischerM1 != null ? mischerM1.hashCode() : 0);
        result = 31 * result + (statusSolarNachladeunterdrueckung != null ? statusSolarNachladeunterdrueckung.hashCode() : 0);
        result = 31 * result + (betriebsArtM1 != null ? betriebsArtM1.hashCode() : 0);
        result = 31 * result + (statusSparbetriebM1 != null ? statusSparbetriebM1.hashCode() : 0);
        result = 31 * result + (statusPartyBetriebM1 != null ? statusPartyBetriebM1.hashCode() : 0);
        result = 31 * result + (solarStunden != null ? solarStunden.hashCode() : 0);
        result = 31 * result + (solarLeistung != null ? solarLeistung.hashCode() : 0);
        result = 31 * result + (tempPartyM1 != null ? tempPartyM1.hashCode() : 0);
        result = 31 * result + (neigungM1 != null ? neigungM1.hashCode() : 0);
        result = 31 * result + (niveauM1 != null ? niveauM1.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HeatingData{" +
                "timestamp=" + timestamp +
                ", tempAussen=" + tempAussen +
                ", tempWWIst=" + tempWWIst +
                ", tempWWSoll=" + tempWWSoll +
                ", tempKesselIst=" + tempKesselIst +
                ", tempKesselSoll=" + tempKesselSoll +
                ", leistung=" + leistung +
                ", tempVorlaufIstM1=" + tempVorlaufIstM1 +
                ", tempVorlaufIstM2=" + tempVorlaufIstM2 +
                ", tempRuecklaufIstM2=" + tempRuecklaufIstM2 +
                ", tempVorlaufSollM1=" + tempVorlaufSollM1 +
                ", tempKollektor=" + tempKollektor +
                ", tempSpeicherUnten=" + tempSpeicherUnten +
                ", tempRaumNormalSollM1=" + tempRaumNormalSollM1 +
                ", tempRaumReduziertSollM1=" + tempRaumReduziertSollM1 +
                ", brennerStarts=" + brennerStarts +
                ", verbrauch=" + verbrauch +
                ", brennerStunden1=" + brennerStunden1 +
                ", statusPumpeM1=" + statusPumpeM1 +
                ", statusSpeicherladepumpe=" + statusSpeicherladepumpe +
                ", statusPumpeZirkulation=" + statusPumpeZirkulation +
                ", statusPumpeSolar=" + statusPumpeSolar +
                ", mischerM1=" + mischerM1 +
                ", statusSolarNachladeunterdrueckung=" + statusSolarNachladeunterdrueckung +
                ", betriebsArtM1='" + betriebsArtM1 + '\'' +
                ", statusSparbetriebM1=" + statusSparbetriebM1 +
                ", statusPartyBetriebM1=" + statusPartyBetriebM1 +
                ", solarStunden=" + solarStunden +
                ", solarLeistung=" + solarLeistung +
                ", tempPartyM1=" + tempPartyM1 +
                ", neigungM1=" + neigungM1 +
                ", niveauM1=" + niveauM1 +
                '}';
    }
}
