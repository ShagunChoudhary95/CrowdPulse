import { useEffect, useState } from "react";
import { getPlaces } from "../services/api";
import Navbar from "../components/Navbar";
import PlaceCard from "../components/PlaceCard";
import { motion, AnimatePresence } from "framer-motion";
import { 
  Search, 
  Compass, 
  MapPin, 
  SlidersHorizontal, 
  Sparkles,
  Landmark,
  Waves,
  Church
} from "lucide-react";

const categories = [
  { id: "ALL", label: "All Destinations", icon: Compass },
  { id: "QUEUE", label: "Sacred Temples", icon: Church },
  { id: "VIBE", label: "Promenades & Coasts", icon: Waves },
  { id: "TIMED", label: "Heritage Monuments", icon: Landmark },
];

export default function Explore() {
  const [places, setPlaces] = useState([]);
  const [loading, setLoading] = useState(true);
  const [selectedCategory, setSelectedCategory] = useState("ALL");
  const [searchQuery, setSearchQuery] = useState("");

  useEffect(() => {
    loadPlaces();
  }, []);

  const loadPlaces = async () => {
    setLoading(true);
    try {
      const data = await getPlaces();
      setPlaces(Array.isArray(data) ? data : []);
    } catch (err) {
      console.error("Error loading places:", err);
    } finally {
      setLoading(false);
    }
  };

  const filteredPlaces = places.filter((p) => {
    const matchesCategory = selectedCategory === "ALL" || p.type === selectedCategory;
    const q = searchQuery.toLowerCase().trim();
    const matchesSearch =
      !q ||
      p.name?.toLowerCase().includes(q) ||
      p.city?.toLowerCase().includes(q) ||
      p.state?.toLowerCase().includes(q) ||
      p.type?.toLowerCase().includes(q);
    return matchesCategory && matchesSearch;
  });

  return (
    <div className="min-h-screen bg-[#F8FAFC]">
      <Navbar />

      <main className="max-w-[1600px] mx-auto px-6 md:px-12 lg:px-16 py-10 md:py-16">
        
        {/* Header */}
        <motion.div
          initial={{ opacity: 0, y: 15 }}
          animate={{ opacity: 1, y: 0 }}
          className="mb-10 space-y-4"
        >
          <div className="inline-flex items-center gap-2 px-3.5 py-1.5 bg-white border border-slate-200 rounded-full shadow-sm text-xs font-semibold text-slate-600">
            <Sparkles className="w-3.5 h-3.5 text-[#FF9933]" />
            <span>Explore Pan-India Sites</span>
          </div>

          <h1 className="text-4xl md:text-5xl font-bold text-slate-900 tracking-tight">
            Discover Live Destinations
          </h1>
          <p className="text-slate-500 text-base md:text-lg max-w-2xl leading-relaxed">
            Browse real-time crowd dynamics, virtual queue status, and operational intelligence across India's premier shrines and cultural landmarks.
          </p>
        </motion.div>

        {/* Controls: Search & Category Filter */}
        <div className="mb-10 space-y-6">
          <div className="flex flex-col md:flex-row gap-4 items-stretch md:items-center justify-between">
            
            {/* Search Input */}
            <div className="relative flex-1 max-w-md">
              <Search className="absolute left-4 top-1/2 -translate-y-1/2 w-4 h-4 text-slate-400" />
              <input
                type="text"
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
                placeholder="Search by name, city, state..."
                className="w-full pl-11 pr-4 py-3 bg-white border border-slate-200 rounded-xl text-slate-800 placeholder-slate-400 text-sm font-medium focus:outline-none focus:border-[#FF9933] focus:ring-2 focus:ring-[#FF9933]/20 shadow-sm transition-all"
              />
            </div>

            {/* Category Pills */}
            <div className="flex items-center gap-2 overflow-x-auto pb-2 md:pb-0 custom-scrollbar">
              {categories.map(({ id, label, icon: Icon }) => (
                <button
                  key={id}
                  onClick={() => setSelectedCategory(id)}
                  className={`flex items-center gap-2 px-4 py-2.5 rounded-xl text-xs md:text-sm font-bold tracking-wide transition-all whitespace-nowrap ${
                    selectedCategory === id
                      ? "bg-[#FF9933] text-white shadow-md shadow-[#FF9933]/20"
                      : "bg-white border border-slate-200 text-slate-600 hover:bg-slate-50 hover:border-slate-300"
                  }`}
                >
                  <Icon className="w-4 h-4" />
                  <span>{label}</span>
                </button>
              ))}
            </div>
          </div>
        </div>

        {/* Places Grid */}
        {loading ? (
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            {[1, 2, 3, 4, 5, 6].map((i) => (
              <div key={i} className="bg-white border border-slate-200 rounded-2xl h-80 animate-pulse" />
            ))}
          </div>
        ) : filteredPlaces.length > 0 ? (
          <motion.div
            layout
            className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6"
          >
            <AnimatePresence>
              {filteredPlaces.map((place) => (
                <motion.div
                  key={place.id}
                  layout
                  initial={{ opacity: 0, scale: 0.95 }}
                  animate={{ opacity: 1, scale: 1 }}
                  exit={{ opacity: 0, scale: 0.95 }}
                  transition={{ duration: 0.2 }}
                >
                  <PlaceCard place={place} />
                </motion.div>
              ))}
            </AnimatePresence>
          </motion.div>
        ) : (
          <div className="text-center py-20 bg-white border border-slate-200 rounded-2xl">
            <Compass className="w-12 h-12 text-slate-300 mx-auto mb-4 animate-bounce" />
            <h3 className="text-lg font-bold text-slate-700 mb-1">No destinations found</h3>
            <p className="text-sm text-slate-400">
              Try adjusting your search terms or selecting "All Destinations".
            </p>
          </div>
        )}
      </main>
    </div>
  );
}