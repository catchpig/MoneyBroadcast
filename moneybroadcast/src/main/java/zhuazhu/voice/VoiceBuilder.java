package zhuazhu.voice;

/**
 * @author 志尧
 * @date on 2018-01-12 15:12
 * @email 1417337180@qq.com
 * @describe 组合音频 实体类
 * @ideas 开头 + 金额 + 单位
 */

public class VoiceBuilder {

    //开头音频
    private String start;
    //播报金额
    private String money;
    //单位
    private String unit;

    public String getStart() {
        return start;
    }

    public String getMoney() {
        return money;
    }

    public String getUnit() {
        return unit;
    }


    public static class Builder {
        private String start;
        private String money;
        private String unit;

        public Builder start(String start) {
            this.start = start;
            return this;
        }

        public Builder money(String money) {
            this.money = money;
            return this;
        }

        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }



        public VoiceBuilder builder() {
            return new VoiceBuilder(this);
        }
    }

    public VoiceBuilder(Builder builder) {
        this.start = builder.start;
        this.money = builder.money;
        this.unit = builder.unit;
    }
}
