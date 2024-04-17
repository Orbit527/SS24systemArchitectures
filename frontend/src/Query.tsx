import GetBookings from "./GetBookings";
import GetCustomers from "./GetCustomers";
import GetFreeRooms from "./GetFreeRooms";
import React, {useState} from "react";
import QueryDatabase from "./QueryDatabase";

export default function Query({returnValue, setReturnValue, setReturnValueFormatted, postMappings}) {
    const [tab, setTab] = useState("GetBookings");

    const getMappings = (url: string) => {
        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(returnValue => {
                setReturnValueFormatted(returnValue);
            });
    };

    return (
        <div>
            <div className="tab-container">
                <button className={`tab-button ${tab === "GetBookings" ? "active-tab" : ""}`} onClick={() => {setTab("GetBookings"); setReturnValue("")}}>Get Booking</button>
                <button className={`tab-button ${tab === "GetCustomers" ? "active-tab" : ""}`} onClick={() => {setTab("GetCustomers"); setReturnValue("")}}>Get Customers</button>
                <button className={`tab-button ${tab === "GetFreeRooms" ? "active-tab" : ""}`} onClick={() => {setTab("GetFreeRooms"); setReturnValue("")}}>Get Free Rooms</button>
                <button className={`tab-button ${tab === "QueryDatabase" ? "active-tab" : ""}`} onClick={() => {setTab("QueryDatabase"); setReturnValue("")}}>Database</button>
            </div>

            <div className="Form">
                {tab === "GetBookings" && <GetBookings postMappings={postMappings}/>}
                {tab === "GetCustomers" && <GetCustomers postMappings={postMappings}/>}
                {tab === "GetFreeRooms" && <GetFreeRooms postMappings={postMappings}/>}
                {tab === "QueryDatabase" && <QueryDatabase getMappings={getMappings}/>}

                <h3>Return Value:</h3>
                <pre>{returnValue}</pre>
            </div>
        </div>
    );
}
