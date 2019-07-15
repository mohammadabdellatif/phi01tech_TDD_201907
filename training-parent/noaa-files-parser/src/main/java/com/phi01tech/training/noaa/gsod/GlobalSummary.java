package com.phi01tech.training.noaa.gsod;

public class GlobalSummary {

    private int gsodId;

    private String stationId;

    private String wbano;
    private String yearModa;

    private String temp;

    private String dewp;

    private String slp;

    private String stp;

    private String visib;

    private String wdsp;

    private String mxspd;

    private String gust;

    private String max;

    private String min;

    private String prcp;

    private String sndp;

    private String frshtt;

    public GlobalSummary() {
    }

    private GlobalSummary(int gsodId,
                          String stationId,
                          String wbano,
                          String yearModa,
                          String temp,
                          String dewp,
                          String slp,
                          String stp,
                          String visib,
                          String wdsp,
                          String mxspd,
                          String gust,
                          String max,
                          String min,
                          String prcp,
                          String sndp,
                          String frshtt) {
        this.gsodId = gsodId;
        this.stationId = stationId;
        this.wbano = wbano;
        this.yearModa = yearModa;
        this.temp = temp;
        this.dewp = dewp;
        this.slp = slp;
        this.stp = stp;
        this.visib = visib;
        this.wdsp = wdsp;
        this.mxspd = mxspd;
        this.gust = gust;
        this.max = max;
        this.min = min;
        this.prcp = prcp;
        this.sndp = sndp;
        this.frshtt = frshtt;
    }

    public String getStationId() {
        return stationId;
    }

    public int getGsodId() {
        return gsodId;
    }

    public String getWbano() {
        return wbano;
    }

    public String getYearModa() {
        return yearModa;
    }

    public String getTemp() {
        return temp;
    }

    public String getDewp() {
        return dewp;
    }

    public String getSlp() {
        return slp;
    }

    public String getStp() {
        return stp;
    }

    public String getVisib() {
        return visib;
    }

    public String getWdsp() {
        return wdsp;
    }

    public String getMxspd() {
        return mxspd;
    }

    public String getGust() {
        return gust;
    }

    public String getMax() {
        return max;
    }

    public String getMin() {
        return min;
    }

    public String getPrcp() {
        return prcp;
    }

    public String getSndp() {
        return sndp;
    }

    public String getFrshtt() {
        return frshtt;
    }

    public static GlobalSummaryBuilder newBuilder() {
        return new GlobalSummaryBuilder();
    }

    public static class GlobalSummaryBuilder {
        private int gsodId;

        private String stationId;

        private String wbano;

        private String yearModa;

        private String temp;

        private String dewp;

        private String slp;

        private String stp;

        private String visib;

        private String wdsp;

        private String mxspd;

        private String gust;

        private String max;

        private String min;

        private String prcp;

        private String sndp;

        private String frshtt;

        public GlobalSummaryBuilder() {
        }

        public GlobalSummaryBuilder setGsodId(int gsodId) {
            this.gsodId = gsodId;
            return this;
        }

        public GlobalSummaryBuilder setStationId(String stationId) {
            this.stationId = stationId;
            return this;
        }


        public GlobalSummaryBuilder setYearModa(String yearModa) {
            this.yearModa = yearModa;
            return this;
        }


        public GlobalSummaryBuilder setTemp(String temp) {
            this.temp = temp;
            return this;
        }


        public GlobalSummaryBuilder setDewp(String dewp) {
            this.dewp = dewp;
            return this;
        }


        public GlobalSummaryBuilder setSlp(String slp) {
            this.slp = slp;
            return this;
        }


        public GlobalSummaryBuilder setStp(String stp) {
            this.stp = stp;
            return this;
        }


        public GlobalSummaryBuilder setVisib(String visib) {
            this.visib = visib;
            return this;
        }


        public GlobalSummaryBuilder setWdsp(String wdsp) {
            this.wdsp = wdsp;
            return this;
        }


        public GlobalSummaryBuilder setMxspd(String mxspd) {
            this.mxspd = mxspd;
            return this;
        }


        public GlobalSummaryBuilder setGust(String gust) {
            this.gust = gust;
            return this;
        }


        public GlobalSummaryBuilder setMax(String max) {
            this.max = max;
            return this;
        }

        public GlobalSummaryBuilder setWbano(String wbano) {
            this.wbano = wbano;
            return this;
        }

        public GlobalSummaryBuilder setMin(String min) {
            this.min = min;
            return this;
        }

        public GlobalSummaryBuilder setPrcp(String prcp) {
            this.prcp = prcp;
            return this;
        }

        public GlobalSummaryBuilder setSndp(String sndp) {
            this.sndp = sndp;
            return this;
        }

        public GlobalSummaryBuilder setFrshtt(String frshtt) {
            this.frshtt = frshtt;
            return this;
        }

        public GlobalSummary build() {
            return new GlobalSummary(gsodId, stationId,
                    wbano,
                    yearModa,
                    temp,
                    dewp,
                    slp,
                    stp,
                    visib,
                    wdsp,
                    mxspd,
                    gust,
                    max,
                    min,
                    prcp,
                    sndp,
                    frshtt);
        }
    }

}
