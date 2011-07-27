package com.vaadin.addon.touchkit.ui;

import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

/**
 * A native looking toolbar, mainly for {@link Button}s. Button icons will be on
 * top of the caption text and each button shall be equally sized.
 * <p>
 * Mostly used with {@link NavigationView}.
 * 
 */
public class Toolbar extends CssLayout {

    /*-
     *  Implementation notes
     *  
     * If we'd want buttons to layout exactly like in ios, we'd need to add 
     * spacers between components and expand spacers. Currently space spread
     * equally and components aligned center.
     */

    private static final String STYLENAME = "v-tk-toolbar";
    private int index;

    /**
     * By default the Toolbar has no margin, is 100% wide and 40px high.
     */
    public Toolbar() {
        setMargin(false);
        setStyleName(STYLENAME);
        setWidth(100, UNITS_PERCENTAGE);
        setHeight(40, UNITS_PIXELS);
    }

    @Override
    public void addComponent(Component c) {
        super.addComponent(c);
        float width = 100 / getComponentCount();
        for (Component component : components) {
            component.setWidth(width, UNITS_PERCENTAGE);
        }
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        index = 0;
        super.paintContent(target);
    }

    @Override
    protected String getCss(Component c) {
        String css = "float:left;";
        index++;
        return css;
    }

}