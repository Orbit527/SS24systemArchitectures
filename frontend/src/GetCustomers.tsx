import React, { useState } from 'react';

export default function GetCustomers({ postMappings }) {
    const [firstname, setFirstname] = useState("");
    const [surname, setSurname] = useState("");

    const handleFirstnameChange = (e) => {
        setFirstname(e.target.value);
    };

    const handleSurnameChange = (e) => {
        setSurname(e.target.value);
    };

    const handleSubmit = () => {
        postMappings('http://localhost:8082/getCustomers', { firstname, surname });
    };

    return (
        <div>
            <h2>Get Customers</h2>
            <div>
                <label htmlFor="firstname">First Name:</label>
                <input
                    type="text"
                    id="firstname"
                    value={firstname}
                    onChange={handleFirstnameChange}
                />
            </div>
            <div>
                <label htmlFor="surname">Surname:</label>
                <input
                    type="text"
                    id="surname"
                    value={surname}
                    onChange={handleSurnameChange}
                />
            </div>
            <button className="submit-button" onClick={handleSubmit}>Get Customers</button>
        </div>
    );
}
