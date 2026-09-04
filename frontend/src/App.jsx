import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Explore from "./pages/Explore";
import PlaceDetail from "./pages/PlaceDetail";
import CommunityPortal from "./pages/CommunityPortal";
import About from "./pages/About";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/explore" element={<Explore />} />
        <Route path="/place/:id" element={<PlaceDetail />} />
        <Route path="/community" element={<CommunityPortal />} />
        <Route path="/about" element={<About />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;