package com.jean.database.gui.handler;

import com.jean.database.gui.view.treeitem.ServerTreeItem;

public interface ServerActionEventHandler extends IRefresh<ServerTreeItem> {

    void openServer(ServerTreeItem serverTreeItem);

    void closeServer(ServerTreeItem serverTreeItem);

    void copyServer(ServerTreeItem serverTreeItem);

    void deleteServer(ServerTreeItem serverTreeItem);

    void serverProperties(ServerTreeItem serverTreeItem);

}
