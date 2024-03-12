package ch.jmotzer.contentcalendar.view;

import ch.jmotzer.contentcalendar.controller.ContentController;
import ch.jmotzer.contentcalendar.model.Content;
import ch.jmotzer.contentcalendar.model.Status;
import ch.jmotzer.contentcalendar.model.Type;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.time.LocalDateTime;

@Route("")
public class ContentView extends VerticalLayout {

    private final ContentController contentController;

    public ContentView(final ContentController contentController) {
        this.contentController = contentController;

        final TextField title = new TextField();
        title.setLabel("Titel");
//        title.setRequired(true);
        final TextField description = new TextField();
        description.setLabel("Beschreibung");
//        description.setRequired(true);

        final ComboBox<Status> statusComboBox = new ComboBox<>();
        statusComboBox.setLabel("Status");
        statusComboBox.setItems(Status.values());
//        statusComboBox.setRequired(true);
        final ComboBox<Type> typeComboBox = new ComboBox<>();
        typeComboBox.setItems(Type.values());
//        typeComboBox.setRequired(true);

        final TextField url = new TextField();
//        url.setRequired(true);

        final Button button = new Button("Hinzufügen");
        button.addClickListener(click -> contentController.create(new Content(null,
                                                                              title.getValue(),
                                                                              description.getValue(),
                                                                              statusComboBox.getValue(),
                                                                              typeComboBox.getValue(),
                                                                              LocalDateTime.now().plusHours(1),
                                                                              null,
                                                                              url.getValue())));


        add(new H1("Content"),
            title,
            description,
            statusComboBox,
            typeComboBox,
            url,
            button);
    }
}
