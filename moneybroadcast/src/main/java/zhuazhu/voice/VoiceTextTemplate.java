package zhuazhu.voice;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import zhuazhu.voice.constant.VoiceConstants;
import zhuazhu.voice.utils.MoneyUtils;

/**
 * 创建时间: 2017/12/26 16:47<br/>
 * 创建人: 李涛<br/>
 * 修改人: 李涛<br/>
 * 修改时间: 2017/12/26 16:47<br/>
 * 描述: 语音组合
 */

public class VoiceTextTemplate {

    /**
     * 音频组合
     *
     * @param voiceBean
     * @return
     */
    public static List<String> genVoiceList(VoiceBuilder voiceBean) {
        List<String> result = new ArrayList<>();
        String[] start = voiceBean.getStart();
        String money = voiceBean.getMoney();
        String unit = voiceBean.getUnit();

        if (TextUtils.isEmpty(money)) {
            return result;
        }

        if (start != null) {
            for (String s : start) {
                if (!TextUtils.isEmpty(s)) {
                    result.add(s);
                }
            }
        }

        if (!TextUtils.isEmpty(money)) {
            result.addAll(genReadableMoney(money));
        }

        if (!TextUtils.isEmpty(unit)) {
            result.add(unit);
        }

        return result;
    }


    /**
     * 全转成 中文 RMB
     *
     * @param numString
     * @return
     */
    private static List<String> genReadableMoney(String numString) {
        List<String> result = new ArrayList<>();
        if (!TextUtils.isEmpty(numString)) {
            if (numString.contains(VoiceConstants.DOT_POINT)) {
                String integerPart = numString.split("\\.")[0];
                String decimalPart = numString.split("\\.")[1];
                List<String> intList = readIntPart(integerPart);
                List<String> decimalList = readDecimalPart(decimalPart);
                result.addAll(intList);
                if (!decimalList.isEmpty()) {
                    result.add(VoiceConstants.DOT);
                    result.addAll(decimalList);
                }
            } else {
                result.addAll(readIntPart(numString));
            }
        }
        return result;
    }

    private static List<String> readDecimalPart(String decimalPart) {
        List<String> result = new ArrayList<>();
        if (!"00".equals(decimalPart)) {
            char[] chars = decimalPart.toCharArray();
            for (char ch : chars) {
                result.add(String.valueOf(ch));
            }
        }
        return result;
    }

    /**
     * 返回数字对应的音频
     *
     * @param integerPart
     * @return
     */
    private static List<String> readIntPart(String integerPart) {
        List<String> result = new ArrayList<>();
        String intString = MoneyUtils.readInt(Integer.parseInt(integerPart));
        int len = intString.length();
        for (int i = 0; i < len; i++) {
            char current = intString.charAt(i);
            if (current == '拾') {
                result.add(VoiceConstants.TEN);
            } else if (current == '佰') {
                result.add(VoiceConstants.HUNDRED);
            } else if (current == '仟') {
                result.add(VoiceConstants.THOUSAND);
            } else if (current == '万') {
                result.add(VoiceConstants.TEN_THOUSAND);
            } else if (current == '亿') {
                result.add(VoiceConstants.TEN_MILLION);
            } else {
                result.add(String.valueOf(current));
            }
        }
        return result;
    }
}
