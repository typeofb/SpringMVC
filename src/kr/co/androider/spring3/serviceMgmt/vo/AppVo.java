package kr.co.androider.spring3.serviceMgmt.vo;

public class AppVo {
    
    public AppVo() {}
    
    private String appId;
    private String appName;
    private String appPkgName;
    private String appVerCode;
    private String appVerName;
    private String appSize;
    private String useFlag;
    private String genUsrId;
    private String genDate;
    private String lastChgUsrId;
    private String lastChgDate;
    
    public String getAppId(){
        return appId;
    }
    
    public void setAppId(String appId){
        this.appId = appId;
    }
    
    public String getAppName(){
        return appName;
    }
    
    public void setAppName(String appName){
        this.appName = appName;
    }
    
    public String getAppPkgName(){
        return appPkgName;
    }
    
    public void setAppPkgName(String appPkgName){
        this.appPkgName = appPkgName;
    }
    
    public String getAppVerCode(){
        return appVerCode;
    }
    
    public void setAppVerCode(String appVerCode){
        this.appVerCode = appVerCode;
    }
    
    public String getAppVerName(){
        return appVerName;
    }
    
    public void setAppVerName(String appVerName){
        this.appVerName = appVerName;
    }
    
    public String getAppSize(){
        return appSize;
    }
    
    public void setAppSize(String appSize){
        this.appSize = appSize;
    }
    
    public String getUseFlag(){
        return useFlag;
    }
    
    public void setUseFlag(String useFlag){
        this.useFlag = useFlag;
    }
    
    public String getGenUsrId(){
        return genUsrId;
    }
    
    public void setGenUsrId(String genUsrId){
        this.genUsrId = genUsrId;
    }
    
    public String getGenDate(){
        return genDate;
    }
    
    public void setGenDate(String genDate){
        this.genDate = genDate;
    }
    
    public String getLastChgUsrId(){
        return lastChgUsrId;
    }
    
    public void setLastChgUsrId(String lastChgUsrId){
        this.lastChgUsrId = lastChgUsrId;
    }
    
    public String getLastChgDate(){
        return lastChgDate;
    }
    
    public void setLastChgDate(String lastChgDate){
        this.lastChgDate = lastChgDate;
    }
}