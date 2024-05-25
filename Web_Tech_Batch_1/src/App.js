import logo from "./logo.svg";
import "./App.css";
import Header from "./components/Header";
import MainNavBar from "./components/MainNavBar";
import "bootstrap/dist/css/bootstrap.min.css"
import { Route, Routes } from "react-router-dom";
import HomeComponent from "./pages/HomeComponent";
import ProductTable from "./pages/ProductTable";
import ProductList from "./pages/ProductList";

function App() {
  return (
    <div>
      <Header></Header>
      <MainNavBar></MainNavBar>
      <Routes>
        <Route path="/" element={<HomeComponent></HomeComponent>}></Route>
        <Route path="/table" element={<ProductTable></ProductTable>}></Route>
        <Route path="/list" element={<ProductList></ProductList>}></Route>
      </Routes>
    </div>
  );
}

export default App;
