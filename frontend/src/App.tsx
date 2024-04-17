import Query from "./Query";
import Command from "./Command";
import React, {useState} from "react";
import './form.css';


export default function App() {
    const [returnValue, setReturnValue] = useState("");
    const [tab, setTab] = useState("Command");

    const setReturnValueFormatted = (returnValue) => {
        // Add line breaks after every {
        returnValue = returnValue.replace(/{/g, '{\n');
        returnValue = returnValue.replace(/},/g, '},\n');

        setReturnValue(returnValue);
    };

    const postMappings = (url, requestBody) => {
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(returnValue => {
                setReturnValueFormatted(returnValue);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    };

    return (
        <div>
            <h1>Hotel Management</h1>
            <div className="tab-container">
                <button className={`tab-button ${tab === "Command" ? "active-tab" : ""}`} onClick={() => { setTab("Command"); setReturnValue("") }}>Write</button>
                <button className={`tab-button ${tab === "Query" ? "active-tab" : ""}`} onClick={() => { setTab("Query"); setReturnValue("") }}>Read</button>
            </div>
            {tab === "Command" && <Command returnValue={returnValue} setReturnValue={setReturnValue} postMappings={postMappings}></Command>}
            {tab === "Query" && <Query returnValue={returnValue} setReturnValue={setReturnValue} setReturnValueFormatted={setReturnValueFormatted} postMappings={postMappings}></Query>}
        </div>
    );
}
