import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class Usage {

    private String name;
    private int usageCount;

    public Usage(String name, int usageCount) {
        this.name = name;
        this.usageCount = usageCount;
    }

    public String getName() {
        return this.name;
    }

    public int getUsageCount() {
        return this.usageCount;
    }

    public void createUsageContent(
            List<String> lines, String name, int usageCount) {
        createUsageHeader(lines);
        createUsageOutputDateTime(lines);
        createUsageDetails(lines, name, usageCount);
    }

    private void createUsageHeader(
            List<String> lines) {
        lines.add("利用回数");
        lines.add("-----");
    }

    private void createUsageOutputDateTime(List<String> lines) {

        final LocalDateTime now = LocalDateTime.now();

        lines.add(
                String.format(
                        " - 出力日時: %s-%s-%s(%s) %s:%s:%s",
                        now.getYear(),
                        now.getMonth(),
                        now.getDayOfMonth(),
                        now.getDayOfWeek()
                                .getDisplayName(
                                        TextStyle.SHORT, Locale.JAPANESE
                                ),
                        now.getHour(),
                        now.getMinute(),
                        now.getSecond()));
    }

    private void createUsageDetails(
            List<String> lines, String name, int usageCount) {

        lines.add(
                String.format(" - 氏名: %s", name));
        lines.add(
                String.format(" - 回数: %s", usageCount));
    }
}
