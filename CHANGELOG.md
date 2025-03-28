# Changelog

## [v0.6.2] - 2025/03/28

### Added

- Full datagen coverage for advancements with non-specific criteria.
- Tipsy VII-X effect tooltips.
- Tipsy I-III effect tooltip translations for Russian and Russian pre-reform locales.
- Chinese localisation.

### Changed

- Brewer's Delight tab name updated for Russian and Russian pre-reform to better match Farmer's Delight tab name.

### Fixed

- Inconsistencies between advancement names and their criteria.

## [v0.6.1] - 2025/02/13

### Added

- Beverage tag, listing every beverage both from Brewers Delight and Brewin' and Chewin'.

### Fixed

- Gut wrecker recipe being inconsistent with the texture.
- Keg from barrel recipe using minecraft:barrel as tag.
- Duplicate keg from barrel recipe.

## [v0.6.0] - 2025/02/08

### Added

- Beverages:
  - Compote.
  - Flying Dutchman.
  - Old fashion.
  - Syta.
  - Vzvar.
- Beverage drafts (added to files, not available in-game due to poor balancing):
    - Absinthe.
    - Amaro.
    - Amontillado.
    - Aperol.
    - Armagnac.
    - Baijiu.
    - Becherovka.
    - Bitter.
    - Calvados.
    - Campari.
    - Chacha.
    - Fernet.
    - Gluhwein.
    - Grog.
    - Kashasa.
    - Mezcal.
    - Negroni.
    - Ouzo.
    - Pastis.
    - Punch.
    - Rakia.
    - Rum.
    - Sambuca.
    - Sherry.
    - Socata.
    - Soju.
    - Sotol.
    - Toddy.
    - Triple-sec.
    - Tsipuro.
    - Tsuike.
    - Vermouth.
    - Vishinata.
- Advancement 'Any vintage beverage'.
- Advancement 'Every vintage beverage'.
- Datagen for models.
- Recipe for turning barrels into kegs.
- Display of tipsy effect levels above 3 on hover.

### Changed

- Balance:
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

## [v0.5.2] - 2024/11/03

### Changed

- Achievements 'Any beverage' and 'Every beverage' now also count Brewin' and Chewin' beverages. Dread Nog, Steel Toe Stout and Withering Dross count as challenging beverages.

## [v0.5.1] - 2024/11/02

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

## [v0.5.0] - 2024/11/01

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

## [v0.4.0] - 2024/10/28

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

## [0.3.0] - 2024/10/28

### Changed

- Renamed class 'AlcoholProperties' to 'BeverageProperties'.
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

## [0.2.0] - 2024/10/27

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

## [0.1.0] - 2024/10/26

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
