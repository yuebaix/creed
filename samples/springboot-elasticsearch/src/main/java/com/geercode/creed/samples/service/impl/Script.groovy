class Script {
    static void main(String[] args) {
        def doc = ["name":"上海招商银行"];
        def briefBankList = ["工商银行","农业银行","中国银行","建设银行","招商银行"];
        def briefLocationList = ["上海", "北京"]
        int score = getScore(doc, briefBankList, briefLocationList);
        println(score);
    }

    static int getScore(Map doc, List briefBankList, List briefLocationList) {
        String bankName = doc["name"].value;
        boolean bankFlag = false;
        for (String briefBank : briefBankList) {
            if (bankName.contains(briefBank)) {
                bankFlag = true;
                break;
            }
        }
        if (!bankFlag) {
            return 0;
        }
        boolean locationFlag = false;
        for (String location : briefLocationList) {
            if (bankName.contains(location)) {
                locationFlag = true;
                break;
            }
        }
        if (!locationFlag) {
            return 0;
        }
        return 1;
    }
}