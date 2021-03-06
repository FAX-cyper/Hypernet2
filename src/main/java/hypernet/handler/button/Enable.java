package hypernet.handler.button;

import java.util.List;

import com.fs.starfarer.api.ui.IntelUIAPI;

import hypernet.HypernetBoard;
import hypernet.IntelQuery;
import hypernet.handler.ButtonHandler;

public class Enable implements ButtonHandler {

    int queryNumber;

    public Enable(int q) {
        queryNumber = q;
    }

    @Override
    public void handle(List<IntelQuery> queries, IntelUIAPI ui) {
        queries.get(queryNumber).enable();
        HypernetBoard.refresh();
    }
}
