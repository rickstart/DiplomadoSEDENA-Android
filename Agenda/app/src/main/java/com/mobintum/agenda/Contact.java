package com.mobintum.agenda;

/**
 * Created by Rick on 23/01/16.
 */
public class Contact {
    private String name;
    private String phone;
    private String email;
    private String photo;
    private String github;

    public Contact(String name, String phone, String email, String photo, String github) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
        this.github = github;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public static Contact[] getContacts(){
        Contact ricardo = new Contact("Ricardo Centeno", "5514382887", "ricardo.celj@gmail.com", "https://avatars2.githubusercontent.com/u/3117867?v=3&s=460", "rickstart");
        Contact sesai = new Contact("Sesai Cornejo", "5548668468", "sesai.cornejo@gmail.com", "https://avatars1.githubusercontent.com/u/13549642?v=3&s=460", "sesai");
        Contact fernando = new Contact("Fernando Alcantar", "5535641548", "falcantarh.bb@gmail.com", "https://avatars2.githubusercontent.com/u/15957914?v=3&u=ca515d908d41c1aa03d7a303599e492841c689e7&s=140", "falcantarh");
        Contact ivan = new Contact("Ivan Contreras Rodriguez", "5524028928", "ivan_c_r@msn.com", "https://avatars2.githubusercontent.com/u/16156249?v=3&s=460", "ivancr2005");
        Contact liho = new Contact("Luis Albeto Liho Piña", "5531150977", "liho@gmail.com", "https://avatars0.githubusercontent.com/u/15957922?v=3&u=aaec284964ae08eb0e674f5d299fe1fd28479272&s=140", "liho1690");
        Contact[] contacts = {ricardo, sesai, fernando, ivan, liho};
        return contacts;
    }
}
