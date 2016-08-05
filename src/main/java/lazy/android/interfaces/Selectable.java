package lazy.android.interfaces;

import java.util.List;
import java.util.Map;

public interface Selectable {
    public void selectByVisibleText(String option);

    public void selectByIndex(int index);

    public void selectByValue(String value);

    public List<String> getAllOptions();

    public String getSelectedOptions();

    public void clear();
}
