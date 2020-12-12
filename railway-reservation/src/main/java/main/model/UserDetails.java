package main.model;

public class UserDetails {
  private String passName;
  private int age;
  private Gender gender;
  private Source depature;
  private Source arrival;
  private Berth_Preference berth_pref;

  public UserDetails(String passName, int age, Gender gender, Source depature, Source arrival,
      Berth_Preference berth_pref) {
    this.passName = passName;
    this.age = age;
    this.gender = gender;
    this.depature = depature;
    this.arrival = arrival;
    this.berth_pref = berth_pref;
  }

  public String getPassName() {
    return passName;
  }

  public void setPassName(String passName) {
    this.passName = passName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Source getDepature() {
    return depature;
  }

  public void setDepature(Source depature) {
    this.depature = depature;
  }

  public Source getArrival() {
    return arrival;
  }

  public void setArrival(Source arrival) {
    this.arrival = arrival;
  }

  public Berth_Preference getBerth_pref() {
    return berth_pref;
  }

  public void setBerth_pref(Berth_Preference berth_pref) {
    this.berth_pref = berth_pref;
  }

}
