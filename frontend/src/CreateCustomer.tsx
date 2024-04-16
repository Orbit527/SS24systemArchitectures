import React, { useState } from 'react';

export default function CreateCustomer({ postMappings }) {
    const [firstname, setFirstname] = useState("");
    const [surname, setSurname] = useState("");
    const [email, setEmail] = useState("");
    const [address, setAddress] = useState("");
    const [birthdate, setBirthdate] = useState("");

    const handleFirstnameChange = (e) => {
        setFirstname(e.target.value);
    };

    const handleSurnameChange = (e) => {
        setSurname(e.target.value);
    };

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    };

    const handleAddressChange = (e) => {
        setAddress(e.target.value);
    };

    const handleBirthdateChange = (e) => {
        setBirthdate(e.target.value);
    };

    const handleSubmit = () => {
        if (!firstname || !surname || !email || !address || !birthdate) {
            alert("Please enter all required information.");
            return;
        }

        const requestBody = {
            firstname,
            surname,
            email,
            address,
            birthdate
        };

        postMappings('http://localhost:8081/createCustomer', requestBody);
    };

    return (
        <div>
            <div>
                <label htmlFor="firstname">First Name:</label>
                <input
                    type="text"
                    id="firstname"
                    value={firstname}
                    onChange={handleFirstnameChange}
                    required
                />
            </div>
            <div>
                <label htmlFor="surname">Surname:</label>
                <input
                    type="text"
                    id="surname"
                    value={surname}
                    onChange={handleSurnameChange}
                    required
                />
            </div>
            <div>
                <label htmlFor="email">Email:</label>
                <input
                    type="email"
                    id="email"
                    value={email}
                    onChange={handleEmailChange}
                    required
                />
            </div>
            <div>
                <label htmlFor="address">Address:</label>
                <input
                    type="text"
                    id="address"
                    value={address}
                    onChange={handleAddressChange}
                    required
                />
            </div>
            <div>
                <label htmlFor="birthdate">Birthdate:</label>
                <input
                    type="date"
                    id="birthdate"
                    value={birthdate}
                    onChange={handleBirthdateChange}
                    required
                />
            </div>
            <button onClick={handleSubmit}>Create Customer</button>
        </div>
    );
}
