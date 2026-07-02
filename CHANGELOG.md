# Changelog

Versions follow the format **`<Minecraft_Version>-<Major>.<Minor>.<Patch>`**, with optional pre-release tags.

| Segment   | Incremented for                                                                         |
|:----------|:----------------------------------------------------------------------------------------|
| **Major** | Complete rewrites                                                                       |
| **Minor** | Changes breaking compatability (large features, new minecraft version support, etc.)    |
| **Patch** | Small changes keeping compatability (small features, bug fixes and optimizations, etc.) |

**Pre-release order** (earliest → stable):
`-a#` alpha → `-b#` beta → `-rc#` release candidate → stable

> **Example:**
> `1.20.1-2.0.0-a1` < `1.20.1-2.0.0-b1` < `1.20.1-2.0.0-rc1` < `1.20.1-2.0.0-rc2` < `1.20.1-2.0.0`

---

# Changelog

## [v0.7.0] — 2026-07-03

### Added

- Vanilla melon slices to #forge:melons tag
- Drinks:
  - Absinthe
  - Bitter
  - Grog
  - Glühwein
  - Punch
  - Toddy
  - Vermouth mushroom variant
- Recipes:
  - Rum from molasses
  - Whisky from barley
  - Sbiten from cinnamon

### Changed

- Renamed martini to vermouth
- Renamed champagne to elderflower
- Tipsy/intoxication on every beverage scaled down (5760–38400 tick spread → 600-12000 tick spread)
- Nourishment effect added to all alcoholic buff drinks to offset Intoxication
- Comfort replaced with Nourishment
- Most fluids recoloured to closer resemble real-life counterparts
- Most drink item textures updated to match average colour to new liquid colours
- Effects (excluding tipsy, intoxication):
  - Braga (Strength I + Slowness I → none; nutrition 6→4)
  - Wine / Grog / Punch (... → none)
  - Kvass (Haste I → Nourishment)
  - Compote (Instant Health + Absorption → Nourishment)
  - Syta (Comfort + Regeneration + Speed → Nourishment)
  - Vzvar (Comfort + Regeneration + Absorption + Saturation → Nourishment + Saturation)
  - Melon Schnapps (Strength I + Hunger → Saturation + Nourishment; +nutrition 3)
  - Whisky (Resistance I + Fire Resistance + Weakness → Resistance I + Nourishment)
  - Bourbon (Fire Resistance + Regeneration → Resistance I + Fire Resistance + Nourishment)
  - Cognac (Resistance II + Regeneration + Saturation + Slowness → Resistance I + Saturation + Nourishment)
  - Sake (Absorption I + Saturation → Absorption I + Nourishment)
  - Cahors (Absorption II + Instant Health + Weakness → Absorption I + Luck + Nourishment)
  - Sbiten (Haste II + Fire Resistance + Health Boost → Haste II + Fire Resistance + Nourishment)
  - Liqueur (Regeneration II + Health Boost → Sweet Heart + Regeneration I + Nourishment)
  - Rum (Strength II + Water Breathing + Confusion → Raging + Nourishment)
  - Cider (Regeneration II → Regeneration I)
  - Brandy (Regeneration + Fire Resistance → Speed II + Jump)
  - Tequila (Speed II + Jump II + Instant Damage → + Weakness)
  - Moonshine (Health Boost II + Night Vision → Night Vision + Speed)
  - Vermouth Glow (Comfort → Glowing + Night Vision)
  - Vermouth Mushroom (Comfort → Health Boost + brief Poison + Nourishment)
  - Flaxen Cheese Stout (Confusion 8400t → 1800t, Blindness 4200t → 1200t)
  - Scarlet Cheese Stout (Confusion 8400t → 1800t, Blindness 4200t → 1200t)
  - Gut Wrecker (Confusion 6000t → 3600t)
- Recipes:
  - Bourbon (Water 1000 mB, 8 min, normal temp, seeds/corn ×2 + apple ×2 → Water 1000 mB, 16 min, warm temp, crops/corn ×4)
  - Brandy (Water 1000 mB, 8 min, normal temp → Cider 750 mB, 16 min, warm temp; output 1000 mB → 500 mB)
  - Cahors (Wine 250 mB, grape ×4 → grape ×2 + sugar ×2)
  - Cognac (Wine 250 mB, 8 min, normal temp, grape ×2 + apple ×2 → Wine 500 mB, 16 min, warm temp, grape ×2)
  - Compote (apple ×4 → fruits tag ×4)
  - Corn whisky (8 min, vegetables/corn ×4 → 4 min, crops/corn ×4)
  - Elderflower (grape ×2 + flowers ×2, normal temp → flowers ×2 + sugar ×2, cold temp)
  - Flaxen cheese stout (normal temp → warm temp)
  - Gut wrecker (Milk 500 mB, normal temp → 250 mB, warm temp; output 1000 mB → 500 mB)
  - Melon schnapps, melon juice (250 mB, 8 min → 500 mB → 500 mB, 4 min → 750 mB)
  - Melon schnapps, water (8 min → 4 min)
  - Moonshine (Braga 250 mB, 8 min, vegetables/corn ×2 + sugar ×2 → 500 mB → Braga 500 mB, 4 min, crops/corn ×2 + sugar ×2 → 750 mB)
  - Old-fashioned (Vodka + Bourbon + Tequila + Whisky → 4 → Bourbon or Whisky + Sugar + Bitter → 2)
  - Sake (normal temp → cold temp)
  - Scarlet cheese stout (Water 250 mB → Beer 500 mB)
  - Syta (8 min → 4 min)
  - Tequila (Vodka 500 mB, cactus ×2 + fruit → Water 500 mB, cactus ×4)
  - Vermouth, glow berries (Wine 250 mB → 500 mB)
  - Vermouth, mushroom (Wine 250 mB → 500 mB)
  - Vzvar, beer route (output 750 mB → 500 mB)
  - Whisky (8 min, normal temp → 16 min, warm temp)

### Fixed

- Typo in fermented drinks tag in Русский (ru_ru) locale ("Ферментитрованные напитки" → "Ферментированные напитки")
- Vzvar from beer recipe not loading
- "Old fashioned" being referred to as "Old fashion"
- Brewer's Delight resources datapack missing the name and showing as incompatible in the datapack selection menu

### Removed

- All glass drink variants
- Fluids:
  - Red wine
  - White wine

### Technical

- "brewersdelight:absinthe" item id, fluid id and translation key added
- "brewersdelight:bitter" item id, fluid id and translation key added
- "brewersdelight:gluhwein" item id, fluid id and translation key added
- "brewersdelight:grog" item id, fluid id and translation key added
- "brewersdelight:punch" item id, fluid id and translation key added
- "brewersdelight:toddy" item id, fluid id and translation key added
- "brewersdelight:vermouth_mushroom" item id, fluid id and translation key added
- "brewersdelight:champagne" item id, fluid id and translation key renamed to "brewersdelight:elderflower"
- "brewersdelight:old_fashion" item id, fluid id and translation key renamed to "brewersdelight:old_fashioned"
- "brewersdelight:martini" item id, fluid id and translation key renamed to "brewersdelight:vermouth_glow_berries"
- "brewersdelight:braga_glass" item and fluid id removed
- "brewersdelight:brandy_glass" item and fluid id removed
- "brewersdelight:gin_glass" item and fluid id removed
- "brewersdelight:kvass_glass" item and fluid id removed
- "brewersdelight:liqueur_glass" item and fluid id removed
- "brewersdelight:martini_glass" item and fluid id removed
- "brewersdelight:melon_schnapps_glass" item and fluid id removed
- "brewersdelight:old_fashion_glass" item and fluid id removed
- "brewersdelight:sake_glass" item and fluid id removed
- "brewersdelight:tequila_glass" item and fluid id removed
- "brewersdelight:whisky_glass" item and fluid id removed
- "brewersdelight:red_wine" fluid id removed
- "brewersdelight:white_wine" fluid id removed

## [v0.7.0-b1] — 2026-06-25

### Added

- Drinks now give tipsy and intoxication effects where applicable
- Translation strings for melon juice and three wine liquids for Русскій дореформенный (rpr) locale
- Advancements for obtaining challenge drinks:
  - Flying Dutchman
  - Gut Wrecker
- Old-fashioned glass variant crafting recipe
- Glass variants for drinks:
  - Kvass
  - Tequila
- Rum from croptopia molasses fermenting recipe
- Croptopia water bottle pouring recipe

### Changed

- Replaced every instance of 'beverage' with more appropriate 'drink'
- Advancements to require either tankard or glass variant, not both
- Русскій дореформенный (rpr) mostly rewritten to remove hypercorrection and provide better overall styling for its time period
- Increased fermenting temperatures:
  - Rum (WARM → HOT) 
  - Flaxen Cheese Stout (NORMAL → WARM)
  - Scarlet Cheese Stout (WARM → HOT)
  - Gut Wrecker (NORMAL → WARM)
- Recipe costs:
  - Compote (TODO: How much?)
  - Rum (4 Sugar Cane → 3 Sugar Cane)
  - Scarlet Cheese Stout (Water → Beer)
- Rebalanced some drinks (TODO: Which ones?)
- Brandy tankard texture to add more colour variety, similar to its glass variant
- Glass variant textures for drinks to add more depth:
  - Braga
  - Melon Schnapps
  - Sake

### Fixed

- Game crashing due to missing registry entries when forge decides to load Brewin' and Chewin' or Farmer's Delight after Brewer's Delight
- Pouring recipes not displaying output item icons
- Missing translation strings for mod melon juice and three wine liquids
- Pouring into glass bottles giving tankard drink variants
- Glass drink variants never being able to refill kegs
- Fermenting recipes not loading:
  - Compote
  - Vzvar from beer
- Vzvar recipe using incorrect ingredients (TODO: How it is now?)
- Incorrect fluid colours (Hex colour code ordering ARGB → RGBA)
- Drinks without fermenting recipes missing pouring recipe
- Flying Dutchman recipe requiring items with non-existent fruits/apple tag instead of apples

## [v0.7.0-a1] (former v0.7.0-pre) — 2025-11-09

### Added

- Fluids for every beverage (Brewin' and Chewin' v3.0 support)
- Glass variants for some beverages (TODO: Which ones?)
- Recipe datagen
- Russian translation for all tags
- Croptopia wine support
- Wine fermenting recipe

### Removed

- Beverages tag in favour of Brewin' and Chewin' "Fermented Drinks" tag

## [v0.6.2] — 2025-03-28

### Added

- Full datagen coverage for advancements with non-specific criteria.
- Tipsy VII-X effect tooltips.
- Tipsy I-III effect tooltip translations for Russian and Russian pre-reform locales.
- Chinese localisation.

### Changed

- Brewer's Delight tab name updated for Russian and Russian pre-reform to better match Farmer's Delight tab name.

### Fixed

- Inconsistencies between advancement names and their criteria.

## [v0.6.1] — 2025-02-13

### Added

- Beverage tag, listing every beverage both from Brewers Delight and Brewin' and Chewin'.

### Fixed

- Gut wrecker recipe being inconsistent with the texture.
- Keg from barrel recipe using minecraft:barrel as tag.
- Duplicate keg from barrel recipe.

## [v0.6.0] — 2025-02-08

### Added

- Beverages:
  - Compote.
  - Flying Dutchman.
  - Old fashion.
  - Syta.
  - Vzvar.
- Advancement 'Any vintage beverage'.
- Advancement 'Every vintage beverage'.
- Datagen for models.
- Recipe for turning barrels into kegs.
- Display of tipsy effect levels above 3 on hover.

### Changed

- Effects:
  - Kvass now increases duration of tipsy effect if it is already applied (spam healing with it while under effects of other beverages now has consequences).
  - Level and duration of speed effect given by braga reduced to level 1 and 2 minutes (because it was a cheap speed 2 potion).
  - Duration of strength effect given by braga reduced to 1 minute (because it was a cheap strength potion).
  - Level of speed given by gin reduced to 2.
  - Duration of strength given by melon schnapps reduced to 1 minute (overshadowed strength potions).
  - Duration of blindness given by melon schnapps reduced to 30 seconds ("blind rage" it gave is useless).
  - Level and duration of absorption effect given by sake reduced to level 2 and 6 minutes.
  - Potency and duration of tipsy effect given by sake increased to level 3 and 5 minutes.
  - Potency and duration of tipsy effect given by tequila increased to level 6 and 20 minutes.
  - Duration of regeneration effect given by cahors decreased to 30 seconds.
  - Duration of jump boost effect given by champagne reduced to 1 minute (overshadowed jump boost potions).
  - Potency of tipsy effect given by cahors increased to level 5.
  - Potency of tipsy effect given by cognac increased to level 5.
  - Duration of tipsy effect given by flaxen cheese stout increased to 12 minutes.
  - Duration of tipsy effect given by scarlet cheese stout increased to 14 minutes.
  - Duration of strength given by whisky reduced to 1 minute.
  - Changed effect given by martini to satisfaction.
  - Rounded duration of tipsy effect for some beverages to preset values.
- Amount of experience given by flaxen cheese stout advancement reduced from 50 to 25.
- Amount of experience given by scarlet cheese stout advancement reduced from 50 to 25.

### Fixed
- Cahors giving impossible invisibility level 2 effect.

## [v0.5.2] — 2024-11-03

### Changed

- Achievements 'Any beverage' and 'Every beverage' now also count Brewin' and Chewin' beverages. Dread Nog, Steel Toe Stout and Withering Dross count as challenging beverages.

## [v0.5.1] — 2024-11-02

### Added

- Achievement for brewing any beverage.
- Achievement for brewing every beverage.
- **(1.20.1 only)** Scarlet Cheese Stout.
- **(1.20.1 only)** Achievement for brewing any challenge beverage.
- **(1.20.1 only)** Achievement for brewing Scarlet Cheese Stout.
- **(1.20.1 only)** Achievement for brewing every challenge beverage.

### Changed

- **(1.20.1 only)** Increased temperature for most fermenting recipes to 'warm'.
- **(1.20.1 only)** Increased result of fermenting recipes - everything using water or milk results in 4, anything else 2, except sbiten (because of its expensive recipe) that results in four and challenge beverages that only result in one.
- **(1.20.1 only)** Sbiten ingredient requirements set to honey block and wheat instead of two honey bottles.
- **(1.20.1 only)** Cheese Stout renamed to Flaxen Cheese Stout.
- **(1.20.1 only)** Flaxen Cheese Stout liquid requirement changed to vodka instead of milk.
- **(1.20.1 only)** Achievement 'All beverages' changed to 'Every beverage'.
- **(1.20.1 only)** Achievement 'Cheese Stout' changed to 'Flaxen Cheese Stout'.

### Fixed

- **(1.20.1 only)** Fermenting recipes not loading properly.
- **(1.20.1 only)** Creative mod tab localisation displaying as raw string.

## [v0.5.0] — 2024-11-01

### Added

- Beverages:
  - Tequila.
  - Cheese Stout.
- Achievement for brewing cheese stout.

### Changed

- Recipes:
    - Sake - added 'minecraft:water_bucket' liquid requirement.
    - Cahors - added 'italian_delight:sweet_berry_wine' liquid requirement.
- Beverages:
    - Braga's tipsy effect strength set to 1, duration set to 2 minutes.
    - Braga's effect set to strength for 2 minutes, speed 2 for 3 minutes.
    - Brandy's tipsy effect strength set to 2, duration set to 4 minutes.
    - Brandy's effect set to water breathing for 3 minutes.
    - Cider's tipsy effect strength set to 2, duration set to 3 minutes.
    - Cider's effect set to regeneration 2 for 3 minutes.
    - Gin's tipsy effect strength set to 3, duration set to 1 minute.
    - Gin's effect set to speed 3 for 4 minutes.
    - Kvass' tipsy effect strength set to 0.
    - Kvass' effect set to instant health.
    - Kvass' nutrition set to 3, saturation to 1.
    - Liqueur's tipsy effect strength set to 3, duration set to 4 minutes.
    - Liqueur's effect set to regeneration 2 for 4 minutes.
    - Martini's tipsy effect strength set to 2, duration set to 2 minutes.
    - Martini's effect set to comfort for 2 minutes.
    - Melon schnapps' tipsy effect strength set to 2, duration set to 15 minutes.
    - Melon schnapps' effect set to blindness for 3 minutes, strength 2 for 3 minutes.
    - Sake's tipsy effect strength set to 1, duration set to 4 minutes.
    - Sake's effect set to absorption 3 for 8 minutes.
    - Sbiten's tipsy effect strength set to 1, duration set to 2 minutes.
    - Sbiten's effect set to haste 2 for 8 minutes.
    - Sbiten's nutrition set to 6, saturation to 3.
    - Whisky's tipsy effect strength set to 3, duration set to 19 minutes.
    - Whisky's effect set to strength 2 for 7 minutes.
    - Bourbon's tipsy effect strength set to 1, duration set to 2 minutes.
    - Bourbon's effect set to fire resistance for 8 minutes.
    - Corn whisky's tipsy effect strength set to 1, duration set to 2 minutes.
    - Corn whisky's effect set to levitation 2 for 1 minute.
    - Moonshine's tipsy effect strength set to 1, duration set to 2 minutes.
    - Moonshine's effect set to health boost 3 for 5 minutes.
    - Cahor's tipsy effect strength set to 1, duration set to 2 minutes.
    - Cahor's effect set to invisibility for 2 minutes, regeneration 3 for 2 minutes.
    - Champagne's tipsy effect strength set to 1, duration set to 2 minutes.
    - Champagne's effect set to jump boost 2 for 3 minutes.
    - Cognac's tipsy effect strength set to 1, duration set to 2 minutes.
    - Cognac's effect set to resistance 3 for 4 minutes.

### Fixed

- Beverages not giving appropriate potion effects after drinking.
- Beverages stacking up to 64 instead of 16.
- Beverages not giving empty tankard back after drinking.

## [v0.4.0] — 2024-10-28

### Changed

- Added logo to readme.
- Replaced placeholder texture in logo.
- Textures:
    - Brandy.
    - Cider.
    - Gin.
    - Kvass.
    - Liqueur.
    - Martini.
    - Melon schnapps.
    - Sake.
    - Whisky.
    - Bourbon.
    - Corn whisky.
    - Moonshine.
    - Cahors.
    - Cognac.

## [0.3.0] — 2024-10-28

### Changed

- Textures:
    - Braga.
    - Brandy.
    - Cider.
    - Gin.
    - Kvass.
    - Liqueur.
    - Martini.
    - Melon schnapps.
    - Sake.
    - Sbiten.
    - Whiskey.
    - Bourbon.
    - Corn whisky.
    - Moonshine.
    - Cahors.
    - Champagne.
    - Cognac.

## [0.2.0] — 2024-10-27

### Added

- Corn Delight compatibility beverages:
    - Bourbon.
    - Corn whisky.
    - Moonshine.
- Italian Delight:
    - Cahors.
    - Champagne.
    - Cognac.

### Changed

- Recipes:
    - Braga - replaced 'minecraft:wheat' item with 'forge:bread' tag.
    - Brandy - replaced 'minecraft:sweet_berries' item with 'forge:berries' tag.
    - Gin - replaced 'minecraft:wheat_seeds' item with 'forge:seeds/wheat' tag; 'minecraft:sweet_berries' item with 'forge:berries' tag; 'minecraft:water_bucket' with 'brewinandchewin:vodka'.
    - Kvass - replaced 'minecraft:wheat' item with 'forge:grain/wheat' tag; 'minecraft:bread' item with 'forge:bread/wheat' tag.
    - Liqueur - replaced 'minecraft:sweet_berries' item with 'forge:berries' tag.
    - Martini from glow berries - replaced 'minecraft:water_bucket' with 'italian_delight:sweet_berry_wine'.
    - Martini from mushroom - replaced 'minecraft:brown_mushroom' item with 'forge:mushrooms' tag; 'minecraft:water_bucket' with 'italian_delight:sweet_berry_wine'.
    - Melon schnapps - replaced 'minecraft:wheat' item with 'forge:grain/wheat' tag.
    - Sake - replaced 'farmersdelight:rice' item with 'forge:grain/rice' tag, removed liquid.
    - Whisky - replaced 'minecraft:wheat' item with 'forge:grain/wheat' tag.
- Translations:
    - Русскій дореформенный (Россійская имперія).

## [0.1.0] — 2024-10-26

### Added

- Brewer's Delight creative tab (group).
- Beverages:
    - Braga.
    - Brandy.
    - Cider.
    - Gin.
    - Kvass.
    - Liqueur.
    - Martini.
    - Melon schnapps.
    - Sake.
    - Sbiten.
    - Whiskey.
- Translations:
    - English (United States).
    - Русский (Россия).
    - Русскій дореформенный (Россійская имперія).
