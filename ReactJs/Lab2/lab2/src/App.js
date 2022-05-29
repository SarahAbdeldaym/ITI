
import React from 'react';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./routing/Header";
import Home from "./routing/Home";
import StudentDetails from "./routing/StudentDetails";
import Error from "./routing/Error";
import About from "./routing/About";

const App = () => {
    return <BrowserRouter>
        <Header />
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="students/:id" element={<StudentDetails />} />
            <Route path="about" element={<About />} />
            <Route path="error" element={<Error />} />
            <Route path="*" element={<Error />} />
        </Routes>
    </BrowserRouter>;
}
export default App;