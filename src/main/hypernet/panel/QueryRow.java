package hypernet.panel;

import java.util.ArrayList;
import java.util.List;

import com.fs.starfarer.api.ui.CustomPanelAPI;
import com.fs.starfarer.api.util.Misc;

import hypernet.IntelQuery;

public class QueryRow extends BoardRow {

    public final static String BUTTON_DELETE = "HYPERNET_DELETE";
    public final static String BUTTON_DISABLE = "HYPERNET_DISABLE";
    public final static String BUTTON_ENABLE = "HYPERNET_ENABLE";
    public final static String BUTTON_REFRESH = "HYPERNET_REFRESH";

    private int queryNumber;
    private IntelQuery query;

    public QueryRow(CustomPanelAPI panel, float width, int queryNumber, IntelQuery query) {
        super(panel, width);
        this.queryNumber = queryNumber;
        this.query = query;
    }

    @Override
    protected List<BoardElement> getLeftElements() {
        List<BoardElement> elements = new ArrayList<>();
        elements.add(new ParaElement(300f, 20f, query.getDescription()));
        return elements;
    }

    @Override
    protected List<BoardElement> getRightElements() {
        String queryIdentifier = "#" + String.valueOf(queryNumber);
        List<BoardElement> elements = new ArrayList<>();
        elements.add(new ButtonElement(120f, 20f, "Delete", BUTTON_DELETE + queryIdentifier, true,
                Misc.getNegativeHighlightColor()));
        elements.add(new ButtonElement(120f, 20f, "Disable", BUTTON_DISABLE + queryIdentifier, query.isEnabled(),
                Misc.getButtonTextColor()));
        elements.add(new ButtonElement(120f, 20f, "Enable", BUTTON_ENABLE + queryIdentifier, !query.isEnabled(),
                Misc.getButtonTextColor()));
        elements.add(new ButtonElement(120f, 20f, "Refresh", BUTTON_REFRESH + queryIdentifier, true,
                Misc.getHighlightColor()));
        elements.add(new ParaElement(100f, 20f, query.getResultCount()));
        return elements;
    }

}