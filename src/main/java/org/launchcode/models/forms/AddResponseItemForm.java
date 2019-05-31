package org.launchcode.models.forms;

import org.launchcode.models.Instrument;
import org.launchcode.models.Response;

import javax.validation.constraints.NotNull;

/**
 * Created by Tracey Cannon Liftoff 0519
 */
public class AddResponseItemForm {

    private Response response;

    private Iterable<Instrument> instruments;

    @NotNull
    private int responseId;

    @NotNull
    private int instrumentId;

    public AddResponseItemForm(Response response, Iterable<Instrument> instruments) {
        this.response = response;
        this.instruments = instruments;
    }

    public AddResponseItemForm() {
    }

    public Response getResponse() {
        return response;
    }

    public Iterable<Instrument> getInstruments() {
        return instruments;
    }

    public int getResponseId() {
        return responseId;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }
}
