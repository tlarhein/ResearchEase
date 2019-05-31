package org.launchcode.models.forms;

import org.launchcode.models.Instrument;
import org.launchcode.models.Response;

import javax.validation.constraints.NotNull;

/**
 * Created by Tracey Cannon Liftoff 0519
 */
public class AddInstrumentItemForm {

    private Instrument instrument;

    private Iterable<Response> responses;

    @NotNull
    private int instrumentId;

    @NotNull
    private int responseId;

    public AddInstrumentItemForm(Instrument instrument, Iterable<Response> responses) {
        this.instrument = instrument;
        this.responses = responses;
    }

    public AddInstrumentItemForm() {
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public Iterable<Response> getResponses() {
        return responses;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public int getResponseId() {
        return responseId;
    }

    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }
}
