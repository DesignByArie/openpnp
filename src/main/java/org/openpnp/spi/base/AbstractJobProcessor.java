package org.openpnp.spi.base;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.Icon;

import org.openpnp.gui.support.PropertySheetWizardAdapter;
import org.openpnp.gui.support.Wizard;
import org.openpnp.spi.JobProcessor;
import org.openpnp.spi.PropertySheetHolder;

public abstract class AbstractJobProcessor implements JobProcessor {
    protected List<TextStatusListener> textStatusListeners = new ArrayList<>();

    @Override
    public String getPropertySheetHolderTitle() {
        return getClass().getSimpleName();
    }

    @Override
    public PropertySheetHolder[] getChildPropertySheetHolders() {
        return null;
    }

    @Override
    public Action[] getPropertySheetHolderActions() {
        return null;
    }

    public PropertySheet[] getPropertySheets() {
        return new PropertySheet[] {new PropertySheetWizardAdapter(getConfigurationWizard())};
    }

    @Override
    public Icon getPropertySheetHolderIcon() {
        return null;
    }

    @Override
    public Wizard getConfigurationWizard() {
        return null;
    }

    @Override
    public void addTextStatusListener(TextStatusListener listener) {
        if (!this.textStatusListeners.contains(listener)) {
            this.textStatusListeners.add(listener);
        }
    }

    @Override
    public void removeTextStatusListener(TextStatusListener listener) {
        this.textStatusListeners.remove(listener);
    }

    protected void fireTextStatus(String format, Object... params) {
        for (TextStatusListener listener : this.textStatusListeners) {
            try {
                listener.textStatus(String.format(format, params));
            }
            catch (Exception e) {

            }
        }
    }
}
