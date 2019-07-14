package com.phi01tech.training.speaker;

public class WebBrowser {

    public enum BrowserName {
        Unknown,
        InternetExplorer,
        Firefox,
        Chrome,
        Opera,
        Safari,
        Dolphin,
        Konqueror,
        Linx
    }

    private BrowserName name;
    private int majorVersion;

    public WebBrowser(BrowserName name, int majorVersion) {
        this.name = name;
        this.majorVersion = majorVersion;
    }

    public BrowserName getName() {
        return name;
    }

    public void setName(BrowserName name) {
        this.name = name;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }
}
