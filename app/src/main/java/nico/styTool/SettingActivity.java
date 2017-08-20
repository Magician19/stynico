package nico.styTool;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;

public class SettingActivity extends PreferenceActivity
{
	CheckBoxPreference cb_use_first_size;

	EditTextPreference edit_delay,edit_output_path1,edit_output_path2,edit_pic_height,edit_pic_width;
	boolean isSelected;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		//this.getListView().setBackgroundResource(R.color.deepskyblue);
		addPreferencesFromResource(R.xml.settings);

		cb_use_first_size = (CheckBoxPreference)findPreference("cb_use_first_size");

		edit_pic_width = (EditTextPreference)findPreference("edit_pic_width");
		edit_pic_height = (EditTextPreference)findPreference("edit_pic_height");

		isSelected=cb_use_first_size.isChecked();
		setTwoEditEnabled();

		cb_use_first_size.setOnPreferenceChangeListener(new OnPreferenceChangeListener()
			{
				public boolean onPreferenceChange(Preference p1, Object p2)
				{
					if (p1.getKey().equals("cb_use_first_size"))
					{
						isSelected=!cb_use_first_size.isChecked();
						setTwoEditEnabled();
					}
					return true;
				}
			});
	}

	public void setTwoEditEnabled()
	{
		if (isSelected&&edit_pic_height.isEnabled())
		{
			edit_pic_height.setEnabled(false);
			edit_pic_width.setEnabled(false);
		}
		else
		{
			edit_pic_height.setEnabled(true);
			edit_pic_width.setEnabled(true);
		}
	}

	@Override
	protected void onDestroy()
	{
		// TODO: Implement this method
		isSelected=false;
		super.onDestroy();
	}

	


}

