package com.ihc.yacm.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName = "";
    private String emailName = "";
    private String emailServiceProvider = "";
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    LoggedInUserView(String displayName,String email) {
        assert email.indexOf('@')>=0;
        this.displayName = displayName;
        this.emailName = email.substring(0,email.indexOf('@'));
        this.emailServiceProvider = email.substring(email.indexOf('@')+1);
    }

    String getDisplayName() {
        return displayName;
    }

    String getEmail() { return emailName+"@"+emailServiceProvider; }

    String getValidID() {
        if (displayName!="")
            return displayName;
        if (emailName!="" && emailServiceProvider!="")
            return emailName+"@"+emailServiceProvider;
        return "";
    }
}
