public class Siparis {

    private  Integer siparisId;
    private Integer malNumarasi;
    private  Integer miktar;
    private Float  birimFiyat;

    public Siparis() {
    }

    public Siparis(Integer siparisId, Integer malNumarasi, Integer miktar, Float  birimFiyat) {
        this.siparisId = siparisId;
        this.malNumarasi = malNumarasi;
        this.miktar = miktar;
        this.birimFiyat = birimFiyat;
    }

    public Integer getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(Integer siparisId) {
        this.siparisId = siparisId;
    }

    public Integer getMalNumarasi() {
        return malNumarasi;
    }

    public void setMalNumarasi(Integer malNumarasi) {
        this.malNumarasi = malNumarasi;
    }

    public Integer getMiktar() {
        return miktar;
    }

    public void setMiktar(Integer miktar) {
        this.miktar = miktar;
    }

    public Float  getBirimFiyat() {
        return birimFiyat;
    }

    public void setBirimFiyat(Float  birimFiyat) {
        this.birimFiyat = birimFiyat;
    }
}
