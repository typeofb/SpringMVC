package kr.co.androider.spring3.controller.bean;

public class AppBean {
    
    private String appId;
    private String appPkgName;
    private String appSize;

    public String getAppId(){
        return appId;
    }

    public void setAppId(String appId){
        this.appId = appId;
    }

    public String getAppPkgName(){
        return appPkgName;
    }

    public void setAppPkgName(String appPkgName){
        this.appPkgName = appPkgName;
    }

    public String getAppSize(){
        return appSize;
    }

    public void setAppSize(String appSize){
        this.appSize = appSize;
    }
}