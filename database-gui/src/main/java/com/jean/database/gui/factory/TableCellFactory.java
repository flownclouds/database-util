package com.jean.database.gui.factory;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.util.Map;

/**
 * @author jinshubao
 */
public class TableCellFactory {


    private static final Callback<TableColumn<Map<String, Object>, Object>, TableCell<Map<String, Object>, Object>> default_cell_factory = param -> new CustomTableCell<>();


    public static Callback<TableColumn<Map<String, Object>, Object>, TableCell<Map<String, Object>, Object>> forTableView() {
        return default_cell_factory;
    }


    private static class CustomTableCell<S, T> extends TableCell<S, T> {

        public CustomTableCell() {
            super();
            ContextMenu contextMenu = new ContextMenu();
            MenuItem copy = new MenuItem("复制");
            copy.setOnAction(event -> {
                ClipboardContent clipboardContent = new ClipboardContent();
                clipboardContent.putString(toString(getItem()));
                Clipboard.getSystemClipboard().setContent(clipboardContent);
            });
            contextMenu.getItems().addAll(copy);
            setContextMenu(contextMenu);
        }

        @Override
        protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(toString(item));
                setWrapText(false);
            }
        }

        private String toString(T item) {
            return item == null ? null : item.toString();
        }
    }
}