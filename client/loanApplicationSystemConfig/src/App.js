import React, { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import axios from "axios";

const styles = {
    container: {
        width: "80%",
        margin: "0 auto",

    },
    input: {
        width: "20%",
        display: "block",
        borderRadius:".45rem",
        height:"30px",
        textAlign:"start",
        margin: "10px",
        position:"relative",
        left : "660px"
    },
    title: {
        textAlign: "center",
        fontFamily: "Arial",
        color: "#3f3fad",
    },
    submit :{
        display: "block",
        borderRadius:".25rem",
        height:"30px",
        textAlign:"center",
        fontFamily: "Arial",
        margin: "10px",
        position:"relative",
        left : "800px",
        width : "90px",
        fontWeight : "bold"
    },
    span :{
        width: "20%",
        height : "20px",
        margin: "10px",
        position:"relative",
        left : "700px",
        backgroundColor:"red",
        color : "white",
        borderRadius:".25rem"
    }
};

export default function App() {
    const { register, errors, formState } = useForm({
        mode: "onBlur",
    });


    const [customerData, setData] = useState(
        { userName: '', monthlyIncome: '', identityNumber: '', phoneNumber: '', result: '' }
    );

    const handleChange = (event) => {
        setData({...customerData, [event.target.name]: event.target.value})
    };

    const handleSubmit = (e) => {
        e.preventDefault()
        axios.post('/education/users', customerData)
            .then(function (response) {
                console.log(response)
            })
            .catch(function (error) {
                console.log(error)
            })
    };

    return (
        <div className="App">
            <h2 style={styles.title}>Loan Application System</h2>
            <form onSubmit={handleSubmit}>
                    <input
                        name="identityNumber"
                        ref={register({
                            required: true,
                            minLength: 11,
                            maxLength: 11,
                            pattern:/^[0-9\b]+$/,
                        })}
                        onChange={handleChange}
                        value={customerData.identityNumber || ''}
                        style={{...styles.input, borderColor: errors.identityNumber && "red"}}
                        placeholder="Identity Number"
                    />
                <span style={styles.span}>
                    {errors.identityNumber && "Please enter your 11-digit ID number"}
                </span>
                <input
                    name="userName"
                    ref={register({
                        required: true,
                        minLength: 6,
                        pattern: /^[A-Za-z]+$/i,
                    })}
                    onChange={handleChange}
                    value={customerData.userName || ''}
                    style={{ ...styles.input ,borderColor: errors.userName && "red"}}
                    placeholder="Username"
                />
                <span style={styles.span}>
                    {errors.username && "Please enter username"}
                </span>
                <input
                    name="monthlyIncome"
                    ref={register({
                        required: true,
                    })}
                    onChange={handleChange}
                    value={customerData.monthlyIncome || ''}
                    style={{ ...styles.input , borderColor: errors.monthlyIncome && "red"}}
                    placeholder="Monthly Income"
                />
                <span style={styles.span}>
                    {errors.monthlyIncome && "Please enter monthly income"}
                </span>
                <input
                    name="phoneNumber"
                    ref={register({
                        required: true,
                        minLength: 10,
                        maxLength: 10,
                        pattern:/^[0-9\b]+$/,
                    })}
                    onChange={handleChange}
                    value={customerData.phoneNumber || ''}
                    style={{ ...styles.input, borderColor: errors.phoneNumber && "red"}}
                    placeholder="Phone Number"
                />
                <span style={styles.span}>
                    {errors.phoneNumber && "Please enter phone number"}
                </span>
                <button style={styles.submit} type="submit" disabled={formState.isSubmitting} value="Submit">
                    Submit
                </button>

                <input
                    name="result"
                    value={customerData.result || ''}
                    onChange={handleChange}
                    style={{ ...styles.input}}
                    placeholder="Score Result"/>
            </form>
        </div>
    );
}