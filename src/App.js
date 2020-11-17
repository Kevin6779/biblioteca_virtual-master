import React from "react";
import "./App.css"
import {
  Navbar,
  Nav
} from "react-bootstrap";
import HomeView from "./views/HomeView";
import  LibrosView  from "./views/LibrosView";
import AgregarLibroView from "./views/AgregarLibroView"
import {BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
function App() {
    return (
    <Router>
      <Navbar bg="dark" expand="lg">
        <Navbar.Brand href="#" style={{color:"white"}} >Biblioteca Virtual</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto">
            <Link style={{color:"white"}} to="/">|Home|</Link>
            <Link style={{color:"white"}} to="/libros">|Libros|</Link>
            <Link style={{color:"white"}} to="/generos">|AgregarLibro|</Link>

          </Nav>
        </Navbar.Collapse>
      </Navbar>
      <Switch>
          <Route exact= {true} path = "/" component ={HomeView}/>
          <Route path = "/libros" component ={LibrosView}/>
          <Route path = "/generos" component ={AgregarLibroView}/>
      </Switch>
    </Router>
  );
}

export default App;
