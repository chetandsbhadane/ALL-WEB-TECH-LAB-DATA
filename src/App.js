import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import {Routes,Route} from 'react-router-dom'
import Header from './components/Header';
import Footer from './components/Footer';
import MainNavBar from './components/MainNavBar';
import ProductTable from './pages/ProductTable';
import HomeComponent from './pages/HomeComponent';
import ProductList from './pages/ProductList';
import ProductForm from './pages/ProductForm';
function App() {
  return (
    <div>
    <Header></Header>
    <MainNavBar></MainNavBar>
    <Routes>
      <Route path="/" element={<HomeComponent></HomeComponent>}></Route>
      <Route path="/table" element={<ProductTable></ProductTable>}></Route>
      <Route path="/list" element={<ProductList></ProductList>}></Route>
      <Route path="/form" element={<ProductForm></ProductForm>}></Route>
    </Routes>
    <Footer></Footer>
    </div>
  );
}

export default App;
