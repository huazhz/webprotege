package edu.stanford.bmir.protege.web.client.tag;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import edu.stanford.bmir.protege.web.shared.renderer.Color;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 19 Mar 2018
 */
public class TagViewImpl extends Composite implements TagView {

    interface TagViewImplUiBinder extends UiBinder<HTMLPanel, TagViewImpl> {
    }

    private static TagViewImplUiBinder ourUiBinder = GWT.create(TagViewImplUiBinder.class);

    @UiField
    HTMLPanel label;

    @Inject
    public TagViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        sinkEvents(Event.ONMOUSEUP);
        sinkEvents(Event.ONMOUSEDOWN);
        sinkEvents(Event.ONMOUSEMOVE);
        sinkEvents(Event.ONMOUSEOUT);
        sinkEvents(Event.ONMOUSEOVER);
        sinkEvents(Event.ONMOUSEWHEEL);
    }

    @Override
    public void setLabel(@Nonnull String label) {
        this.label.getElement().setInnerText(checkNotNull(label));
    }

    @Override
    public void setDescription(@Nonnull String description) {
        label.setTitle(description);
    }

    @Override
    public void setColor(@Nonnull Color color) {
        label.getElement().getStyle().setColor(checkNotNull(color).getHex());
    }

    @Override
    public void setBackgroundColor(@Nonnull Color backgroundColor) {
        label.getElement().getStyle().setBackgroundColor(checkNotNull(backgroundColor).getHex());
    }

    @Override
    public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
        return label.addHandler(handler, MouseUpEvent.getType());
    }

    @Override
    public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
        return label.addHandler(handler, MouseDownEvent.getType());
    }

    @Override
    public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
        return label.addHandler(handler, MouseMoveEvent.getType());
    }

    @Override
    public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
        return label.addHandler(handler, MouseOutEvent.getType());
    }

    @Override
    public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
        return label.addHandler(handler, MouseOverEvent.getType());
    }

    @Override
    public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
        return label.addHandler(handler, MouseWheelEvent.getType());
    }
}