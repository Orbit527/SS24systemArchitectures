import CreateBooking from "./CreateBooking";
import CancelBooking from "./CancelBooking";
import CreateCustomer from "./CreateCustomer";
import CreateRoom from "./CreateRoom";
import React, {useState} from "react";

export default function Command({returnValue, setReturnValue, postMappings}) {
    const [tab, setTab] = useState("CreateBooking");

    return (
        <div>
            <div className="tab-container">
                <button className={`tab-button ${tab === "CreateBooking" ? "active-tab" : ""}`} onClick={() => { setTab("CreateBooking"); setReturnValue("") }}>Create Booking</button>
                <button className={`tab-button ${tab === "CancelBooking" ? "active-tab" : ""}`} onClick={() => { setTab("CancelBooking"); setReturnValue("") }}>Cancel Booking</button>
                <button className={`tab-button ${tab === "CreateCustomer" ? "active-tab" : ""}`} onClick={() => { setTab("CreateCustomer"); setReturnValue("") }}>Create Customer</button>
                <button className={`tab-button ${tab === "CreateRoom" ? "active-tab" : ""}`} onClick={() => { setTab("CreateRoom"); setReturnValue("") }}>Create Room</button>
            </div>

            <div className="Form">
                {tab === "CreateBooking" && <CreateBooking postMappings={postMappings}/>}
                {tab === "CancelBooking" && <CancelBooking postMappings={postMappings}/>}
                {tab === "CreateCustomer" && <CreateCustomer postMappings={postMappings}/>}
                {tab === "CreateRoom" && <CreateRoom postMappings={postMappings}/>}

                <h3>Return Value:</h3>
                <pre>{returnValue}</pre>
            </div>
        </div>
    );
}
