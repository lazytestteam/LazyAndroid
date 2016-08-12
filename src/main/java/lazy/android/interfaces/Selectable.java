package lazy.android.interfaces;

import java.util.List;

public interface Selectable {
	public void selectByVisibleText(String option);

	public void selectByIndex(int index);

	public void selectByValue(String value);

	public List<String> getAllOptions();

	public String getSelectedOptions();

	public void clear();
}
