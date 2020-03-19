package com.jean.database.gui.view.handler;

import com.jean.database.gui.view.DataTableView;

public interface IDataTableActionEventHandler extends IRefreshActionEventHandler<DataTableView> {

    void refresh(DataTableView dataTableView, int page);
}